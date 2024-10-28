package com.sini.blocking_extensions.global.exception.custom;

public class DuplicateExtensionException extends RuntimeException {
    public DuplicateExtensionException(final String message) {
        super(message);
    }
}
