package com.sini.blocking_extensions.global.exception.custom;

public class NotFoundFileException extends RuntimeException {
    public NotFoundFileException(final String message) {
        super(message);
    }
}
