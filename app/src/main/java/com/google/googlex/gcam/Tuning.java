package com.google.googlex.gcam;

public class Tuning {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public Tuning() {
        this(GcamModuleJNI.new_Tuning(), true);
    }

    protected Tuning(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Tuning tuning) {
        if (tuning == null) {
            return 0L;
        }
        return tuning.swigCPtr;
    }

    public boolean Check() {
        return GcamModuleJNI.Tuning_Check(this.swigCPtr, this);
    }

    public CaptureParams GetCaptureParams() {
        return new CaptureParams(GcamModuleJNI.Tuning_GetCaptureParams(this.swigCPtr, this), false);
    }

    public ColorSatParams GetColorSatAdj() {
        return new ColorSatParams(GcamModuleJNI.Tuning_GetColorSatAdj(this.swigCPtr, this), false);
    }

    public SWIGTYPE_p_gcam__SmoothKeyValueMapT_gcam__RawVignetteParams_t GetExtraFinishVignetting(int i) {
        return new SWIGTYPE_p_gcam__SmoothKeyValueMapT_gcam__RawVignetteParams_t(GcamModuleJNI.Tuning_GetExtraFinishVignetting(this.swigCPtr, this, i), true);
    }

    public float GetMaxOverallGain() {
        return GcamModuleJNI.Tuning_GetMaxOverallGain(this.swigCPtr, this);
    }

    public float GetMaxTet() {
        return GcamModuleJNI.Tuning_GetMaxTet(this.swigCPtr, this);
    }

    public float GetMinExposureTimeMs() {
        return GcamModuleJNI.Tuning_GetMinExposureTimeMs(this.swigCPtr, this);
    }

    public float GetMinTet() {
        return GcamModuleJNI.Tuning_GetMinTet(this.swigCPtr, this);
    }

    public TetModel GetPayloadBurstTetModel(int i) {
        return new TetModel(GcamModuleJNI.Tuning_GetPayloadBurstTetModel__SWIG_1(this.swigCPtr, this, i), true);
    }

    public TetModel GetPayloadBurstTetModel(int i, float f) {
        return new TetModel(GcamModuleJNI.Tuning_GetPayloadBurstTetModel__SWIG_0(this.swigCPtr, this, i, f), true);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_Tuning(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    public boolean getApply_antibanding() {
        return GcamModuleJNI.Tuning_apply_antibanding_get(this.swigCPtr, this);
    }

    public float getBase_frame_candidate_exposure_time_cutoff_ms() {
        return GcamModuleJNI.Tuning_base_frame_candidate_exposure_time_cutoff_ms_get(this.swigCPtr, this);
    }

    public int getBase_frame_candidates_in_bright_scene() {
        return GcamModuleJNI.Tuning_base_frame_candidates_in_bright_scene_get(this.swigCPtr, this);
    }

    public int getBase_frame_candidates_in_dark_scene() {
        return GcamModuleJNI.Tuning_base_frame_candidates_in_dark_scene_get(this.swigCPtr, this);
    }

    public PixelRect getBlack_pixel_area_override() {
        long Tuning_black_pixel_area_override_get = GcamModuleJNI.Tuning_black_pixel_area_override_get(this.swigCPtr, this);
        if (Tuning_black_pixel_area_override_get != 0) {
            return new PixelRect(Tuning_black_pixel_area_override_get, false);
        }
        return null;
    }

    public int getFickle_payload_frames() {
        return GcamModuleJNI.Tuning_fickle_payload_frames_get(this.swigCPtr, this);
    }

    public boolean getIgnore_black_pixels() {
        return GcamModuleJNI.Tuning_ignore_black_pixels_get(this.swigCPtr, this);
    }

    public boolean getIgnore_pd_for_moving_lens() {
        return GcamModuleJNI.Tuning_ignore_pd_for_moving_lens_get(this.swigCPtr, this);
    }

    public float getMax_black_level_offset() {
        return GcamModuleJNI.Tuning_max_black_level_offset_get(this.swigCPtr, this);
    }

    public float getMax_exposure_time_ms() {
        return GcamModuleJNI.Tuning_max_exposure_time_ms_get(this.swigCPtr, this);
    }

    public RawFinishParams getRaw_finish_params() {
        long Tuning_raw_finish_params_get = GcamModuleJNI.Tuning_raw_finish_params_get(this.swigCPtr, this);
        if (Tuning_raw_finish_params_get != 0) {
            return new RawFinishParams(Tuning_raw_finish_params_get, false);
        }
        return null;
    }

    public RawVignetteParams getRaw_global_vignetting() {
        long Tuning_raw_global_vignetting_get = GcamModuleJNI.Tuning_raw_global_vignetting_get(this.swigCPtr, this);
        if (Tuning_raw_global_vignetting_get != 0) {
            return new RawVignetteParams(Tuning_raw_global_vignetting_get, false);
        }
        return null;
    }

    public RawMergeParams getRaw_merge_params() {
        long Tuning_raw_merge_params_get = GcamModuleJNI.Tuning_raw_merge_params_get(this.swigCPtr, this);
        if (Tuning_raw_merge_params_get != 0) {
            return new RawMergeParams(Tuning_raw_merge_params_get, false);
        }
        return null;
    }

    public CaptureParams getRaw_payload_capture_params() {
        long Tuning_raw_payload_capture_params_get = GcamModuleJNI.Tuning_raw_payload_capture_params_get(this.swigCPtr, this);
        if (Tuning_raw_payload_capture_params_get != 0) {
            return new CaptureParams(Tuning_raw_payload_capture_params_get, false);
        }
        return null;
    }

    public float getSensitivity() {
        return GcamModuleJNI.Tuning_sensitivity_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__functionT_gcam__DngNoiseModel_fint_float_floatF_t getSensor_noise_model_override_bayer() {
        long Tuning_sensor_noise_model_override_bayer_get = GcamModuleJNI.Tuning_sensor_noise_model_override_bayer_get(this.swigCPtr, this);
        if (Tuning_sensor_noise_model_override_bayer_get != 0) {
            return new SWIGTYPE_p_std__functionT_gcam__DngNoiseModel_fint_float_floatF_t(Tuning_sensor_noise_model_override_bayer_get, false);
        }
        return null;
    }

    public SensorRowArtifacts getSensor_row_artifacts() {
        long Tuning_sensor_row_artifacts_get = GcamModuleJNI.Tuning_sensor_row_artifacts_get(this.swigCPtr, this);
        if (Tuning_sensor_row_artifacts_get != 0) {
            return new SensorRowArtifacts(Tuning_sensor_row_artifacts_get, false);
        }
        return null;
    }

    public BadPixelPattern getSparse_pd_pixel_pattern() {
        long Tuning_sparse_pd_pixel_pattern_get = GcamModuleJNI.Tuning_sparse_pd_pixel_pattern_get(this.swigCPtr, this);
        if (Tuning_sparse_pd_pixel_pattern_get != 0) {
            return new BadPixelPattern(Tuning_sparse_pd_pixel_pattern_get, false);
        }
        return null;
    }

    public boolean getSuppress_hot_pixels() {
        return GcamModuleJNI.Tuning_suppress_hot_pixels_get(this.swigCPtr, this);
    }

    public void setApply_antibanding(boolean z) {
        GcamModuleJNI.Tuning_apply_antibanding_set(this.swigCPtr, this, z);
    }

    public void setBase_frame_candidate_exposure_time_cutoff_ms(float f) {
        GcamModuleJNI.Tuning_base_frame_candidate_exposure_time_cutoff_ms_set(this.swigCPtr, this, f);
    }

    public void setBase_frame_candidates_in_bright_scene(int i) {
        GcamModuleJNI.Tuning_base_frame_candidates_in_bright_scene_set(this.swigCPtr, this, i);
    }

    public void setBase_frame_candidates_in_dark_scene(int i) {
        GcamModuleJNI.Tuning_base_frame_candidates_in_dark_scene_set(this.swigCPtr, this, i);
    }

    public void setBlack_pixel_area_override(PixelRect pixelRect) {
        GcamModuleJNI.Tuning_black_pixel_area_override_set(this.swigCPtr, this, PixelRect.getCPtr(pixelRect), pixelRect);
    }

    public void setFickle_payload_frames(int i) {
        GcamModuleJNI.Tuning_fickle_payload_frames_set(this.swigCPtr, this, i);
    }

    public void setIgnore_black_pixels(boolean z) {
        GcamModuleJNI.Tuning_ignore_black_pixels_set(this.swigCPtr, this, z);
    }

    public void setIgnore_pd_for_moving_lens(boolean z) {
        GcamModuleJNI.Tuning_ignore_pd_for_moving_lens_set(this.swigCPtr, this, z);
    }

    public void setMax_black_level_offset(float f) {
        GcamModuleJNI.Tuning_max_black_level_offset_set(this.swigCPtr, this, f);
    }

    public void setMax_exposure_time_ms(float f) {
        GcamModuleJNI.Tuning_max_exposure_time_ms_set(this.swigCPtr, this, f);
    }

    public void setRaw_finish_params(RawFinishParams rawFinishParams) {
        GcamModuleJNI.Tuning_raw_finish_params_set(this.swigCPtr, this, RawFinishParams.getCPtr(rawFinishParams), rawFinishParams);
    }

    public void setRaw_global_vignetting(RawVignetteParams rawVignetteParams) {
        GcamModuleJNI.Tuning_raw_global_vignetting_set(this.swigCPtr, this, RawVignetteParams.getCPtr(rawVignetteParams), rawVignetteParams);
    }

    public void setRaw_merge_params(RawMergeParams rawMergeParams) {
        GcamModuleJNI.Tuning_raw_merge_params_set(this.swigCPtr, this, RawMergeParams.getCPtr(rawMergeParams), rawMergeParams);
    }

    public void setRaw_payload_capture_params(CaptureParams captureParams) {
        GcamModuleJNI.Tuning_raw_payload_capture_params_set(this.swigCPtr, this, CaptureParams.getCPtr(captureParams), captureParams);
    }

    public void setSensitivity(float f) {
        GcamModuleJNI.Tuning_sensitivity_set(this.swigCPtr, this, f);
    }

    public void setSensor_noise_model_override_bayer(SWIGTYPE_p_std__functionT_gcam__DngNoiseModel_fint_float_floatF_t sWIGTYPE_p_std__functionT_gcam__DngNoiseModel_fint_float_floatF_t) {
        GcamModuleJNI.Tuning_sensor_noise_model_override_bayer_set(this.swigCPtr, this, SWIGTYPE_p_std__functionT_gcam__DngNoiseModel_fint_float_floatF_t.getCPtr(sWIGTYPE_p_std__functionT_gcam__DngNoiseModel_fint_float_floatF_t));
    }

    public void setSensor_row_artifacts(SensorRowArtifacts sensorRowArtifacts) {
        GcamModuleJNI.Tuning_sensor_row_artifacts_set(this.swigCPtr, this, SensorRowArtifacts.getCPtr(sensorRowArtifacts), sensorRowArtifacts);
    }

    public void setSparse_pd_pixel_pattern(BadPixelPattern badPixelPattern) {
        GcamModuleJNI.Tuning_sparse_pd_pixel_pattern_set(this.swigCPtr, this, BadPixelPattern.getCPtr(badPixelPattern), badPixelPattern);
    }

    public void setSuppress_hot_pixels(boolean z) {
        GcamModuleJNI.Tuning_suppress_hot_pixels_set(this.swigCPtr, this, z);
    }
}
