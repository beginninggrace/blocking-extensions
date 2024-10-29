package com.sini.blocking_extensions.global.exception.custom;

public class ExtensionLimitExceededException extends RuntimeException {
    public ExtensionLimitExceededException(final String message) {
        super(message);
    }
}
