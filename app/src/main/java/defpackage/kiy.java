package defpackage;

public final class kiy implements Comparable<kiy> {
    private final int[] a;

    public kiy(String str) {
        int length;
        String[] split = str.split("\\.");
        if (split == null || (length = split.length) < 2) {
            throw new IllegalArgumentException(str.length() == 0 ? "Unrecognized version name is found: " : "Unrecognized version name is found: ".concat(str));
        }
        this.a = new int[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.a[i] = Integer.parseInt(split[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(str.length() == 0 ? "Unrecognized version name is found: " : "Unrecognized version name is found: ".concat(str));
            }
        }
    }

    public final int a(kiy kiyVar) {
        int length;
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            length = iArr.length;
            if (i >= length) {
                break;
            }
            int[] iArr2 = kiyVar.a;
            if (i >= iArr2.length) {
                break;
            }
            int i2 = iArr[i];
            int i3 = iArr2[i];
            if (i2 > i3) {
                return 1;
            }
            if (i2 < i3) {
                return -1;
            }
            i++;
        }
        int length2 = kiyVar.a.length;
        if (length < length2) {
            while (true) {
                int[] iArr3 = kiyVar.a;
                if (length >= iArr3.length) {
                    break;
                }
                int i4 = iArr3[length];
                if (i4 > 0) {
                    return 1;
                }
                if (i4 < 0) {
                    return -1;
                }
                length++;
            }
        } else {
            while (true) {
                int[] iArr4 = this.a;
                if (length2 >= iArr4.length) {
                    break;
                }
                int i5 = iArr4[length2];
                if (i5 > 0) {
                    return 1;
                }
                if (i5 < 0) {
                    return -1;
                }
                length2++;
            }
        }
        return 0;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(kiy obj) {
        return a(obj);
    }
}