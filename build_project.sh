#!/usr/bin/env bash

set -e

export MERGED_DEX_FILE="app/build/intermediates/dex/release/mergeDexRelease/classes.dex"
export DISASSEMBLY_PATH="/tmp/dummy-dump-GCam-6.2.030"
export BASE_PORT_DIR="/home/madnessknight/projects/GCam-6.2.030"

export GIT_WORK_TREE="$BASE_PORT_DIR"
export GIT_DIR="$BASE_PORT_DIR/.git"

main()
{
  rm -rf "$DISASSEMBLY_PATH" || true
  mkdir -p "$DISASSEMBLY_PATH" || true

 git reset --hard HEAD &
 git clean -df &

  ./gradlew dexBuilderDebug mergeDexRelease
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
  apktool build "$BASE_PORT_DIR" ; uber-apk-signer -a "$BASE_PORT_DIR"/dist --overwrite
}

main "$@"
unset MERGED_DEX_FILE DISASSEMBLY_PATH BASE_PORT_DIR GIT_WORK_TREE GIT_DIR