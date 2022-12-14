package com.google.googlex.gcam;

public class ProgressCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public ProgressCallback() {
        this(GcamModuleJNI.new_ProgressCallback(), true);
        GcamModuleJNI.ProgressCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ProgressCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ProgressCallback progressCallback) {
        if (progressCallback == null) {
            return 0L;
        }
        return progressCallback.swigCPtr;
    }

    public void Run(int i, float f) {
        GcamModuleJNI.ProgressCallback_Run(this.swigCPtr, this, i, f);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_ProgressCallback(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        GcamModuleJNI.ProgressCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.ProgressCallback_change_ownership(this, this.swigCPtr, true);
    }
}
