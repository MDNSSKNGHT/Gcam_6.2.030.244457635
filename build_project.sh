#!/usr/bin/env bash

set -e

export MERGED_DEX_FILE="app/build/intermediates/dex/release/mergeDexRelease/classes.dex"
export DISASSEMBLY_PATH="/tmp/dummy-dump-Gcam_6.2.030.244457635"
export BASE_PORT_DIR="$PROJECT_DIRECTORY/Gcam_6.2.030.244457635/apk-base"

export GIT_WORK_TREE="$BASE_PORT_DIR"
export GIT_DIR="$BASE_PORT_DIR/.git"

main()
{
  if ! [ -d "$BASE_PORT_DIR" ]; then
      wget "https://2-dontsharethislink.celsoazevedo.com/file/filesc/MGC_6.2.030_MI9SE_V4_plus2.apk"
      apktool decode "MGC_6.2.030_MI9SE_V4_plus2.apk" --output "apk-base"
      git init "$BASE_PORT_DIR" -b main
      git add .
      git commit -s "Initial commit"
  fi

  rm -rf "$DISASSEMBLY_PATH" || true
  mkdir -p "$DISASSEMBLY_PATH" || true

  git reset --hard HEAD
  git clean -df

  ./gradlew mergeDexRelease
  baksmali disassemble "$MERGED_DEX_FILE" -o "$DISASSEMBLY_PATH"
  find "$DISASSEMBLY_PATH"/com "$DISASSEMBLY_PATH"/defpackage -name "*.smali" -exec sed -i 's/defpackage\///g' {} \;
  find "$DISASSEMBLY_PATH"/com "$DISASSEMBLY_PATH"/defpackage -name "*.smali" -exec sh -c '
          CURRENT_SMALI_FILE=$1
          TARGET_SMALI_FILES=(
            "dfa.smali"
            "dfa\$1.smali"
            "mpj.smali"
            "MetadataConverter.smali"
            "MetadataConverter\$\$ExternalSyntheticLambda0.smali"
            "MetadataConverter\$ExtendedFaces.smali"
            "MetadataConverter\$LandmarkIndex.smali" )

          for target in ${TARGET_SMALI_FILES[@]}; do
            if [[ "${CURRENT_SMALI_FILE##*/}" == "$target" ]]; then
              if [[ "$CURRENT_SMALI_FILE" =~ defpackage ]]; then
                cp "$CURRENT_SMALI_FILE" "$BASE_PORT_DIR"/smali
              else
                cp $CURRENT_SMALI_FILE "$BASE_PORT_DIR"/smali/"${CURRENT_SMALI_FILE#"$DISASSEMBLY_PATH/"}"
              fi
            fi
          done
  ' sh {} \;

  pushd "$BASE_PORT_DIR"
  for patch in "$PROJECT_DIRECTORY"/Gcam_6.2.030.244457635/apk-patches/*.patch; do
    git apply "$patch"
  done
  popd

  apktool build --use-aapt1 "$BASE_PORT_DIR" ; uber-apk-signer -a "$BASE_PORT_DIR"/dist --overwrite
}

main "$@"
unset MERGED_DEX_FILE DISASSEMBLY_PATH BASE_PORT_DIR GIT_WORK_TREE GIT_DIR