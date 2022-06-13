package com.google.googlex.gcam;

public class InterleavedImageU8 extends InterleavedWriteViewU8 {
    public long swigCPtr;

    public InterleavedImageU8() {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_0(), true);
    }

    public InterleavedImageU8(int i, int i2, int i3) {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_3(i, i2, i3), true);
    }

    public InterleavedImageU8(int i, int i2, int i3, int i4) {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_2(i, i2, i3, i4), true);
    }

    public InterleavedImageU8(int i, int i2, int i3, int i4, long j) {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_5(i, i2, i3, i4, j), true);
    }

    public InterleavedImageU8(int i, int i2, int i3, int i4, long j, SWIGTYPE_p_gcam__TImageSampleAllocator sWIGTYPE_p_gcam__TImageSampleAllocator) {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_4(i, i2, i3, i4, j, SWIGTYPE_p_gcam__TImageSampleAllocator.getCPtr(sWIGTYPE_p_gcam__TImageSampleAllocator)), true);
    }

    public InterleavedImageU8(int i, int i2, int i3, int i4, SWIGTYPE_p_gcam__TImageSampleAllocator sWIGTYPE_p_gcam__TImageSampleAllocator) {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_1(i, i2, i3, i4, SWIGTYPE_p_gcam__TImageSampleAllocator.getCPtr(sWIGTYPE_p_gcam__TImageSampleAllocator)), true);
    }

    public InterleavedImageU8(int i, int i2, int i3, long j, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, SWIGTYPE_p_gcam__TImageSampleAllocator sWIGTYPE_p_gcam__TImageSampleAllocator) {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_6(i, i2, i3, j, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), SWIGTYPE_p_gcam__TImageSampleAllocator.getCPtr(sWIGTYPE_p_gcam__TImageSampleAllocator)), true);
    }

    protected InterleavedImageU8(long j, boolean z) {
        super(GcamModuleJNI.InterleavedImageU8_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public InterleavedImageU8(InterleavedImageU8 interleavedImageU8) {
        this(GcamModuleJNI.new_InterleavedImageU8__SWIG_7(getCPtr(interleavedImageU8), interleavedImageU8), true);
    }

    protected static long getCPtr(InterleavedImageU8 interleavedImageU8) {
        if (interleavedImageU8 == null) {
            return 0L;
        }
        return interleavedImageU8.swigCPtr;
    }

    @Override
    public void FastCrop(int i, int i2, int i3, int i4) {
        GcamModuleJNI.InterleavedImageU8_FastCrop_SWIG_0_1(this.swigCPtr, this, i, i2, i3, i4);
    }

    @Override
    public void FastCrop(int i, int i2, int i3, int i4, int i5, int i6) {
        GcamModuleJNI.InterleavedImageU8_FastCrop_SWIG_0_0(this.swigCPtr, this, i, i2, i3, i4, i5, i6);
    }

    @Override
    public boolean SamplesAreCompact() {
        return GcamModuleJNI.InterleavedImageU8_SamplesAreCompact(this.swigCPtr, this);
    }

    public SWIGTYPE_p_gcam__TImageSampleAllocator allocator() {
        long InterleavedImageU8_allocator = GcamModuleJNI.InterleavedImageU8_allocator(this.swigCPtr, this);
        if (InterleavedImageU8_allocator != 0) {
            return new SWIGTYPE_p_gcam__TImageSampleAllocator(InterleavedImageU8_allocator, false);
        }
        return null;
    }

    @Override
    public long c_stride() {
        return GcamModuleJNI.InterleavedImageU8_c_stride(this.swigCPtr, this);
    }

    @Override
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_InterleavedImageU8(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    protected void finalize() {
        delete();
    }

    @Override
    public int height() {
        return GcamModuleJNI.InterleavedImageU8_height(this.swigCPtr, this);
    }

    @Override
    public int num_channels() {
        return GcamModuleJNI.InterleavedImageU8_num_channels(this.swigCPtr, this);
    }

    @Override
    public int row_padding() {
        return GcamModuleJNI.InterleavedImageU8_row_padding(this.swigCPtr, this);
    }

    @Override
    public long sample_array_size() {
        return GcamModuleJNI.InterleavedImageU8_sample_array_size(this.swigCPtr, this);
    }

    @Override
    public long sizeof_sample_type() {
        return GcamModuleJNI.InterleavedImageU8_sizeof_sample_type(this.swigCPtr, this);
    }

    @Override
    public int width() {
        return GcamModuleJNI.InterleavedImageU8_width(this.swigCPtr, this);
    }

    @Override
    public long x_stride() {
        return GcamModuleJNI.InterleavedImageU8_x_stride(this.swigCPtr, this);
    }

    @Override
    public long y_stride() {
        return GcamModuleJNI.InterleavedImageU8_y_stride(this.swigCPtr, this);
    }
}
