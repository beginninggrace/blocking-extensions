package com.sini.blocking_extensions.dto;

import com.sini.blocking_extensions.entity.FixedExtension;
import lombok.Getter;

@Getter
public class FixedExtensionResponse {

    private String extensionName;

    public FixedExtensionResponse(FixedExtension fixedExtension) {
        this.extensionName = fixedExtension.getExtensionName();
    }

    public FixedExtensionResponse(String extensionName) {
        this.extensionName = extensionName;
    }
}
