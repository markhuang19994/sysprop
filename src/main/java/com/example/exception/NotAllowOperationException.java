package com.example.exception;

public class NotAllowOperationException extends RuntimeException {

    public NotAllowOperationException() {
    }

    public NotAllowOperationException(String s) {
        super(s);
    }

    public NotAllowOperationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotAllowOperationException(Throwable throwable) {
        super(throwable);
    }

    public NotAllowOperationException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
