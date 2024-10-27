package com.sini.blocking_extensions.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private HttpStatus status;
    private String message;


}
