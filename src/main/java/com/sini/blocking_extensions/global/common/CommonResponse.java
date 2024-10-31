package com.sini.blocking_extensions.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

    private T data;

    public static <T> CommonResponse<T> ok(T data) {
        return CommonResponse.<T>builder()
            .data(data)
            .build();
    }

}
