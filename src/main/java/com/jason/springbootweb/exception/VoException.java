package com.jason.springbootweb.exception;

public class VoException extends RuntimeException {
    public VoException() {
        super();
    }

    public VoException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoException(String message) {
        super(message);
    }
}
