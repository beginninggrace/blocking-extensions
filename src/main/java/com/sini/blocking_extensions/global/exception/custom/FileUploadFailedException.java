package com.sini.blocking_extensions.global.exception.custom;

public class FileUploadFailedException extends RuntimeException {
    public FileUploadFailedException(final String message) {
        super(message);
    }
}
