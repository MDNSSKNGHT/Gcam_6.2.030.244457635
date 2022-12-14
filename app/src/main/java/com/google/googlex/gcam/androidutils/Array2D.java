package com.google.googlex.gcam.androidutils;

import com.google.googlex.gcam.androidutils.vecmath.Vector2i;
import com.google.googlex.gcam.androidutils.vecmath.Vector4b;
import com.google.googlex.gcam.androidutils.vecmath.Vector4f;
import com.google.googlex.gcam.androidutils.vecmath.Vector4i;
import com.google.googlex.gcam.androidutils.vecmath.Vector4s;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import defpackage.ohr;

public class Array2D {
    public final ByteBuffer buffer;
    public final int elementSizeBytes;
    public final int elementStrideBytes;
    public final int height;
    public final int originIndex;
    public final int rowStrideBytes;
    public final int width;

    public class F32x1 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 4;

        public F32x1(int i, int i2) {
            this(i, i2, 4, i << 2);
        }

        public F32x1(int i, int i2, int i3, int i4) {
            super(i, i2, 4, i3, i4);
        }

        public F32x1(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 4, i3, i4, byteBuffer, i5);
        }

        public float get(int i, int i2) {
            return this.buffer.getFloat(subscriptToIndex(i, i2));
        }

        public void set(int i, int i2, float f) {
            this.buffer.putFloat(subscriptToIndex(i, i2), f);
        }
    }

    public static class F32x4 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 16;

        public F32x4(int i, int i2) {
            this(i, i2, 16, i << 4);
        }

        public F32x4(int i, int i2, int i3, int i4) {
            super(i, i2, 16, i3, i4);
        }

        public F32x4(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 16, i3, i4, byteBuffer, i5);
        }

        public F32x4 cropped(int i, int i2, int i3, int i4) {
            boolean z = true;
            ohr.a(i >= 0, "x >= 0, %s", i);
            ohr.a(i2 >= 0, "y >= 0, %s", i2);
            ohr.a(i3 > 0, "width > 0, %s", i3);
            ohr.a(i4 > 0, "height > 0, %s", i4);
            ohr.a(i + i3 <= width(), "x + width <= width(): %s + %s <= %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(width()));
            if (i2 + i4 > height()) {
                z = false;
            }
            ohr.a(z, "y + height <= height(): %s + %s <= %s", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(height()));
            return new F32x4(i3, i4, this.elementStrideBytes, this.rowStrideBytes, this.buffer, this.originIndex + (i2 * rowStrideBytes()) + (i * elementStrideBytes()));
        }

        public F32x4 flippedLeftRight() {
            int i = this.originIndex;
            int i2 = this.width;
            int i3 = this.elementStrideBytes;
            return new F32x4(i2, this.height, -i3, this.rowStrideBytes, this.buffer, ((i2 - 1) * i3) + i);
        }

        public F32x4 flippedUpDown() {
            int i = this.originIndex;
            int i2 = this.height;
            int i3 = this.rowStrideBytes;
            return new F32x4(this.width, i2, this.elementStrideBytes, -i3, this.buffer, ((i2 - 1) * i3) + i);
        }

        public Vector4f get(int i, int i2) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            return new Vector4f(this.buffer.getFloat(subscriptToIndex), this.buffer.getFloat(subscriptToIndex + 1), this.buffer.getFloat(subscriptToIndex + 2), this.buffer.getFloat(subscriptToIndex + 3));
        }

        public void set(int i, int i2, float f, float f2, float f3, float f4) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            this.buffer.putFloat(subscriptToIndex, f);
            this.buffer.putFloat(subscriptToIndex + 1, f2);
            this.buffer.putFloat(subscriptToIndex + 2, f3);
            this.buffer.putFloat(subscriptToIndex + 3, f4);
        }

        public void set(int i, int i2, Vector4f vector4f) {
            set(i, i2, vector4f.x, vector4f.y, vector4f.z, vector4f.w);
        }
    }

    public static class S32x4 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 16;

        public S32x4(int i, int i2) {
            this(i, i2, 16, i << 4);
        }

        public S32x4(int i, int i2, int i3, int i4) {
            super(i, i2, 16, i3, i4);
        }

        public S32x4(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 16, i3, i4, byteBuffer, i5);
        }

        public Vector4i get(int i, int i2) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            return new Vector4i(this.buffer.getInt(subscriptToIndex), this.buffer.getInt(subscriptToIndex + 1), this.buffer.getInt(subscriptToIndex + 2), this.buffer.getInt(subscriptToIndex + 3));
        }

        public void set(int i, int i2, int i3, int i4, int i5, int i6) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            this.buffer.putInt(subscriptToIndex, i3);
            this.buffer.putInt(subscriptToIndex + 1, i4);
            this.buffer.putInt(subscriptToIndex + 2, i5);
            this.buffer.putInt(subscriptToIndex + 3, i6);
        }

        public void set(int i, int i2, Vector4i vector4i) {
            set(i, i2, vector4i.x, vector4i.y, vector4i.z, vector4i.w);
        }
    }

    public class U16x1 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 2;

        public U16x1(int i, int i2) {
            this(i, i2, 2, i + i);
        }

        public U16x1(int i, int i2, int i3, int i4) {
            super(i, i2, 2, i3, i4);
        }

        public U16x1(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 2, i3, i4, byteBuffer, i5);
        }

        public short get(int i, int i2) {
            return this.buffer.getShort(subscriptToIndex(i, i2));
        }

        public void set(int i, int i2, short s) {
            this.buffer.putShort(subscriptToIndex(i, i2), s);
        }
    }

    public static class U16x4 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 8;

        public U16x4(int i, int i2) {
            this(i, i2, 8, i << 3);
        }

        public U16x4(int i, int i2, int i3, int i4) {
            super(i, i2, 8, i3, i4);
        }

        public U16x4(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 8, i3, i4, byteBuffer, i5);
        }

        public Vector4s get(int i, int i2) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            return new Vector4s(this.buffer.getShort(subscriptToIndex), this.buffer.getShort(subscriptToIndex + 1), this.buffer.getShort(subscriptToIndex + 2), this.buffer.getShort(subscriptToIndex + 3));
        }

        public void set(int i, int i2, short s, short s2, short s3, short s4) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            this.buffer.putShort(subscriptToIndex, s);
            this.buffer.putShort(subscriptToIndex + 1, s2);
            this.buffer.putShort(subscriptToIndex + 2, s3);
            this.buffer.putShort(subscriptToIndex + 3, s4);
        }
    }

    public static class U32x4 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 16;

        public U32x4(int i, int i2) {
            this(i, i2, 16, i << 4);
        }

        public U32x4(int i, int i2, int i3, int i4) {
            super(i, i2, 16, i3, i4);
        }

        public U32x4(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 16, i3, i4, byteBuffer, i5);
        }

        public Vector4i get(int i, int i2) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            return new Vector4i(this.buffer.getInt(subscriptToIndex), this.buffer.getInt(subscriptToIndex + 1), this.buffer.getInt(subscriptToIndex + 2), this.buffer.getInt(subscriptToIndex + 3));
        }

        public void set(int i, int i2, int i3, int i4, int i5, int i6) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            this.buffer.putInt(subscriptToIndex, i3);
            this.buffer.putInt(subscriptToIndex + 1, i4);
            this.buffer.putInt(subscriptToIndex + 2, i5);
            this.buffer.putInt(subscriptToIndex + 3, i6);
        }

        public void set(int i, int i2, Vector4i vector4i) {
            set(i, i2, vector4i.x, vector4i.y, vector4i.z, vector4i.w);
        }
    }

    public class U8x1 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 1;

        public U8x1(int i, int i2) {
            this(i, i2, 1, i);
        }

        public U8x1(int i, int i2, int i3, int i4) {
            super(i, i2, 1, i3, i4);
        }

        public U8x1(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 1, i3, i4, byteBuffer, i5);
        }

        public byte get(int i, int i2) {
            return this.buffer.get(subscriptToIndex(i, i2));
        }

        public void set(int i, int i2, byte b) {
            this.buffer.put(subscriptToIndex(i, i2), b);
        }
    }

    public static class U8x4 extends Array2D {
        public static final int ELEMENT_SIZE_BYTES = 4;

        public U8x4(int i, int i2) {
            this(i, i2, 4, i << 2);
        }

        public U8x4(int i, int i2, int i3, int i4) {
            super(i, i2, 4, i3, i4);
        }

        public U8x4(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
            super(i, i2, 4, i3, i4, byteBuffer, i5);
        }

        public Vector4b get(int i, int i2) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            return new Vector4b(this.buffer.get(subscriptToIndex), this.buffer.get(subscriptToIndex + 1), this.buffer.get(subscriptToIndex + 2), this.buffer.get(subscriptToIndex + 3));
        }

        public void set(int i, int i2, byte b, byte b2, byte b3, byte b4) {
            int subscriptToIndex = subscriptToIndex(i, i2);
            this.buffer.put(subscriptToIndex, b);
            this.buffer.put(subscriptToIndex + 1, b2);
            this.buffer.put(subscriptToIndex + 2, b3);
            this.buffer.put(subscriptToIndex + 3, b4);
        }

        public void set(int i, int i2, Vector4b vector4b) {
            set(i, i2, vector4b.x, vector4b.y, vector4b.z, vector4b.w);
        }
    }

    protected Array2D(int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        ohr.a(i > 0, "width must be positive: %s", i);
        ohr.a(i2 > 0, "height must be positive: %s", i2);
        ohr.a(i3 > 0, "elementSizeBytes must be positive: %s", i3);
        ohr.a(i4 > 0, "elementStrideBytes must be positive: %s", i4);
        ohr.a(i4 >= i3, "elementStrideBytes must be at least as big as elementSizeBytes: %s >= %s", i4, i3);
        ohr.a(i5 > 0, "rowStrideBytes must be positive: %s", i5);
        ohr.a(i5 < i * i4 ? false : z, "rowStrideBytes %s should be greater than or equal to width * elementStrideBytes: %s * %s ", Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i4));
        this.width = i;
        this.height = i2;
        this.elementSizeBytes = i3;
        this.elementStrideBytes = i4;
        this.rowStrideBytes = i5;
        this.buffer = ByteBuffer.allocateDirect(i5 * i2).order(ByteOrder.nativeOrder());
        this.originIndex = 0;
    }

    protected Array2D(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer, int i6) {
        boolean z = true;
        ohr.a(i > 0, "width must be positive: %s", i);
        ohr.a(i2 > 0, "height must be positive: %s", i2);
        ohr.a(i3 > 0, "elementSizeBytes must be positive: %s", i3);
        ohr.b(byteBuffer, "buffer must not be null.");
        ohr.a(i6 < 0 ? false : z, "originIndex %s must be >= 0.", i6);
        this.width = i;
        this.height = i2;
        this.elementSizeBytes = i3;
        this.elementStrideBytes = i4;
        this.rowStrideBytes = i5;
        this.buffer = byteBuffer;
        this.originIndex = i6;
    }

    public static Array2D createUpsideDownView(Array2D array2D, Class cls) {
        int i = array2D.originIndex;
        int i2 = array2D.height;
        int i3 = array2D.rowStrideBytes;
        int i4 = i + ((i2 - 1) * i3);
        try {
            return (Array2D) cls.getConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, array2D.buffer.getClass(), Integer.TYPE).newInstance(Integer.valueOf(array2D.width), Integer.valueOf(array2D.height), Integer.valueOf(array2D.elementStrideBytes), Integer.valueOf(-i3), array2D.buffer, Integer.valueOf(i4));
        } catch (Exception e) {
            //pao.a.b(e);
            return null;
        }
    }

    public Buffer buffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public int elementStrideBytes() {
        return this.elementStrideBytes;
    }

    public boolean elementsArePacked() {
        return this.elementSizeBytes == this.elementStrideBytes;
    }

    public int height() {
        return this.height;
    }

    public boolean isPacked() {
        return elementsArePacked() && rowsArePacked();
    }

    public int rowStrideBytes() {
        return this.rowStrideBytes;
    }

    public boolean rowsArePacked() {
        return this.elementSizeBytes * width() == this.rowStrideBytes;
    }

    public Vector2i size() {
        return new Vector2i(this.width, this.height);
    }

    public Vector2i stride() {
        return new Vector2i(this.elementStrideBytes, this.rowStrideBytes);
    }

    protected int subscriptToIndex(int i, int i2) {
        return this.originIndex + (i2 * this.rowStrideBytes) + (i * this.elementStrideBytes);
    }

    public int width() {
        return this.width;
    }
}
