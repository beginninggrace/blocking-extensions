package com.sini.blocking_extensions.controller;

import com.sini.blocking_extensions.dto.FileCreateResponse;
import com.sini.blocking_extensions.global.common.CommonResponse;
import com.sini.blocking_extensions.service.FileService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/files")
public class FileController {

    private final FileService fileService;

    @PostMapping()
    public CommonResponse<FileCreateResponse> saveFile(@RequestParam("file")MultipartFile file) {
        return CommonResponse.ok(fileService.saveFile(file));
    }

}
