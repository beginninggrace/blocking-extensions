package com.sini.blocking_extensions.global.exception.custom;

public class BlockedExtensionException extends RuntimeException {
    public BlockedExtensionException(final String message) {
        super(message);
    }
}
