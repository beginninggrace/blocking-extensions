package com.sini.blocking_extensions.global.exception.custom;

public class NotMatchedExtensionNameException extends RuntimeException {
    public NotMatchedExtensionNameException(final String message) {
        super(message);
    }
}
