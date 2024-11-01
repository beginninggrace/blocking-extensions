package com.sini.blocking_extensions.dto;

import lombok.Getter;

@Getter
public class FileReadResponse {

    private Long fileId;
    private String preSignedUrl;

    public FileReadResponse(Long fileId, String preSignedUrl) {
        this.fileId = fileId;
        this.preSignedUrl = preSignedUrl;
    }

}
