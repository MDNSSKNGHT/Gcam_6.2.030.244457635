package com.google.googlex.gcam.androidutils.camera2;

public class TimeoutRuntimeException extends RuntimeException {
    public TimeoutRuntimeException(String str) {
        super(str);
    }

    public TimeoutRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
