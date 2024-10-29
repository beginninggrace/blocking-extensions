package com.sini.blocking_extensions.global.exception;

import com.sini.blocking_extensions.global.exception.custom.DuplicateExtensionException;
import com.sini.blocking_extensions.global.exception.custom.ExtensionLimitExceededException;
import com.sini.blocking_extensions.global.exception.custom.NotFoundExtensionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j(topic = "GlobalExceptionHandler")
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundExtensionException.class)
    public ResponseEntity<ExceptionResponse> notFoundExtensionException(final NotFoundExtensionException e) {
        log.error(e.getMessage());
        return createResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(DuplicateExtensionException.class)
    public ResponseEntity<ExceptionResponse> duplicateExtensionException(final DuplicateExtensionException e) {
        log.error(e.getMessage());
        return createResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ExtensionLimitExceededException.class)
    public ResponseEntity<ExceptionResponse> extensionLimitExceededException(final ExtensionLimitExceededException e) {
        log.error(e.getMessage());
        return createResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    private ResponseEntity<ExceptionResponse> createResponse(
        final HttpStatus status,
        final String message
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(new ExceptionResponse(status, message));
    }
}
