package com.google.googlex.gcam;

public class SimpleCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public SimpleCallback() {
        this(GcamModuleJNI.new_SimpleCallback(), true);
        GcamModuleJNI.SimpleCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected SimpleCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SimpleCallback simpleCallback) {
        if (simpleCallback == null) {
            return 0L;
        }
        return simpleCallback.swigCPtr;
    }

    public void Run() {
        GcamModuleJNI.SimpleCallback_Run(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_SimpleCallback(j);
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
        GcamModuleJNI.SimpleCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.SimpleCallback_change_ownership(this, this.swigCPtr, true);
    }
}
