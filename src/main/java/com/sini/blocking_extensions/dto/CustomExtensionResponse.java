package com.sini.blocking_extensions.dto;

import lombok.Getter;

@Getter
public class CustomExtensionResponse {
    private String extensionName;

    public CustomExtensionResponse(String customExtensionName) {
        this.extensionName = customExtensionName;
    }
}
