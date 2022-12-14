package com.google.googlex.gcam;

public class AeDebugInfo {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public AeDebugInfo() {
        this(GcamModuleJNI.new_AeDebugInfo(), true);
    }

    protected AeDebugInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AeDebugInfo aeDebugInfo) {
        if (aeDebugInfo == null) {
            return 0L;
        }
        return aeDebugInfo.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_AeDebugInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    public float getExec_time_dual_ae_sec() {
        return GcamModuleJNI.AeDebugInfo_exec_time_dual_ae_sec_get(this.swigCPtr, this);
    }

    public FloatVector getMetering_frame_capture_gains() {
        long AeDebugInfo_metering_frame_capture_gains_get = GcamModuleJNI.AeDebugInfo_metering_frame_capture_gains_get(this.swigCPtr, this);
        if (AeDebugInfo_metering_frame_capture_gains_get != 0) {
            return new FloatVector(AeDebugInfo_metering_frame_capture_gains_get, false);
        }
        return null;
    }

    public SWIGTYPE_p_std__vectorT_gcam__DngNoiseModel_t getMetering_frame_noise_models() {
        long AeDebugInfo_metering_frame_noise_models_get = GcamModuleJNI.AeDebugInfo_metering_frame_noise_models_get(this.swigCPtr, this);
        if (AeDebugInfo_metering_frame_noise_models_get != 0) {
            return new SWIGTYPE_p_std__vectorT_gcam__DngNoiseModel_t(AeDebugInfo_metering_frame_noise_models_get, false);
        }
        return null;
    }

    public int getNum_faces() {
        return GcamModuleJNI.AeDebugInfo_num_faces_get(this.swigCPtr, this);
    }

    public AeModeResult getOriginal_result() {
        long AeDebugInfo_original_result_get = GcamModuleJNI.AeDebugInfo_original_result_get(this.swigCPtr, this);
        if (AeDebugInfo_original_result_get != 0) {
            return new AeModeResult(AeDebugInfo_original_result_get, false);
        }
        return null;
    }

    public void setExec_time_dual_ae_sec(float f) {
        GcamModuleJNI.AeDebugInfo_exec_time_dual_ae_sec_set(this.swigCPtr, this, f);
    }

    public void setMetering_frame_capture_gains(FloatVector floatVector) {
        GcamModuleJNI.AeDebugInfo_metering_frame_capture_gains_set(this.swigCPtr, this, FloatVector.getCPtr(floatVector), floatVector);
    }

    public void setMetering_frame_noise_models(SWIGTYPE_p_std__vectorT_gcam__DngNoiseModel_t sWIGTYPE_p_std__vectorT_gcam__DngNoiseModel_t) {
        GcamModuleJNI.AeDebugInfo_metering_frame_noise_models_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_gcam__DngNoiseModel_t.getCPtr(sWIGTYPE_p_std__vectorT_gcam__DngNoiseModel_t));
    }

    public void setNum_faces(int i) {
        GcamModuleJNI.AeDebugInfo_num_faces_set(this.swigCPtr, this, i);
    }

    public void setOriginal_result(AeModeResult aeModeResult) {
        GcamModuleJNI.AeDebugInfo_original_result_set(this.swigCPtr, this, AeModeResult.getCPtr(aeModeResult), aeModeResult);
    }
}
