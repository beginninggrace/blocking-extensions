package com.sini.blocking_extensions.global.exception.custom;

public class NotFoundBucketException extends RuntimeException {
    public NotFoundBucketException(final String message) {
        super(message);
    }
}
