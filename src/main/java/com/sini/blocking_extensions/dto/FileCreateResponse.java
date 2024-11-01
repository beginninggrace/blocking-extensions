package com.sini.blocking_extensions.dto;

import lombok.Getter;

@Getter
public class FileCreateResponse {

    private Long fileId;
    private String fileName;

    public FileCreateResponse(Long fileId, String originalFilename) {
        this.fileId = fileId;
        this.fileName = originalFilename;
    }
}
