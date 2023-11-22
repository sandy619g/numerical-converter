package com.app.converter.exception;

public class NumeralException extends RuntimeException {

    public NumeralException(String message) {
        super(message);
    }

    public NumeralException(String message, Throwable cause) {
        super(message, cause);
    }
}

