package com.sini.blocking_extensions.controller;

import com.sini.blocking_extensions.common.CommonResponse;
import com.sini.blocking_extensions.dto.FixedExtensionRequest;
import com.sini.blocking_extensions.dto.FixedExtensionResponse;
import com.sini.blocking_extensions.service.FixedExtensionService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/extensions")
public class FixedExtensionController {

    private final FixedExtensionService fixedExtensionService;

    @PostMapping
    public void setFixedExtension(@Valid @RequestBody FixedExtensionRequest request) {
        fixedExtensionService.setFixedExtension(request);
    }

    @GetMapping
    public CommonResponse<List<FixedExtensionResponse>> getAllFixedExtensions() {
        return CommonResponse.ok(fixedExtensionService.getAllFixedExtensions());
    }

    @DeleteMapping
    public void deleteFixedExtension(@Valid @RequestBody FixedExtensionRequest request) {
        fixedExtensionService.deleteFixedExtension(request);
    }
}
