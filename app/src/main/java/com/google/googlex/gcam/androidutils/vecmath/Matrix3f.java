package com.google.googlex.gcam.androidutils.vecmath;

public class Matrix3f {
    public float m00;
    public float m01;
    public float m02;
    public float m10;
    public float m11;
    public float m12;
    public float m20;
    public float m21;
    public float m22;

    public Matrix3f() {
    }

    public Matrix3f(float f) {
        this.m00 = f;
        this.m10 = f;
        this.m20 = f;
        this.m01 = f;
        this.m11 = f;
        this.m21 = f;
        this.m02 = f;
        this.m12 = f;
        this.m22 = f;
    }

    Matrix3f(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.m00 = f;
        this.m10 = f4;
        this.m20 = f7;
        this.m01 = f2;
        this.m11 = f5;
        this.m21 = f8;
        this.m02 = f3;
        this.m12 = f6;
        this.m22 = f9;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Matrix3f) {
            if (obj == this) {
                return true;
            }
            Matrix3f matrix3f = (Matrix3f) obj;
            return this.m00 == matrix3f.m00 && this.m10 == matrix3f.m10 && this.m20 == matrix3f.m20 && this.m01 == matrix3f.m01 && this.m11 == matrix3f.m11 && this.m21 == matrix3f.m21 && this.m02 == matrix3f.m02 && this.m12 == matrix3f.m12 && this.m22 == matrix3f.m22;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((Float.floatToIntBits(this.m00) * 31) + Float.floatToIntBits(this.m01)) * 31) + Float.floatToIntBits(this.m02)) * 31) + Float.floatToIntBits(this.m10)) * 31) + Float.floatToIntBits(this.m11)) * 31) + Float.floatToIntBits(this.m12)) * 31) + Float.floatToIntBits(this.m20)) * 31) + Float.floatToIntBits(this.m21)) * 31) + Float.floatToIntBits(this.m22);
    }

    public float[] toFloatArray() {
        return new float[]{this.m00, this.m10, this.m20, this.m01, this.m11, this.m21, this.m02, this.m12, this.m22};
    }

    public String toString() {
        return String.format("[\t%f\t%f\t%f\t]\n[\t%f\t%f\t%f\t]\n[\t%f\t%f\t%f\t]", Float.valueOf(this.m00), Float.valueOf(this.m01), Float.valueOf(this.m02), Float.valueOf(this.m10), Float.valueOf(this.m11), Float.valueOf(this.m12), Float.valueOf(this.m20), Float.valueOf(this.m21), Float.valueOf(this.m22));
    }
}
