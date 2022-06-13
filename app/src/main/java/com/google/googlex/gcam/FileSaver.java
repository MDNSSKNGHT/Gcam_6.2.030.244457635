package com.google.googlex.gcam;

public class FileSaver {
    public boolean swigCMemOwn;
    public long swigCPtr;

    protected FileSaver(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FileSaver fileSaver) {
        if (fileSaver == null) {
            return 0L;
        }
        return fileSaver.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_FileSaver(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }
}
