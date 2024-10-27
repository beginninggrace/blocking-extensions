package com.sini.blocking_extensions.global.exception;

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
