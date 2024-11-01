package com.sini.blocking_extensions.global.exception.custom;

public class FileSizeLimitException extends RuntimeException {
    public FileSizeLimitException(final String message) {
        super(message);
    }
}
