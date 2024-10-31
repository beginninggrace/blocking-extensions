package com.sini.blocking_extensions.controller;

import com.sini.blocking_extensions.global.common.CommonResponse;
import com.sini.blocking_extensions.dto.CustomExtensionRequest;
import com.sini.blocking_extensions.dto.CustomExtensionResponse;
import com.sini.blocking_extensions.service.CustomExtensionService;
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
@RequestMapping("/v1/custom-extensions")
public class CustomExtensionController {

    private final CustomExtensionService customExtensionService;

    @PostMapping
    public void setCustomExtension(@Valid @RequestBody CustomExtensionRequest request) {
        customExtensionService.setCustomExtension(request);
    }

    @GetMapping
    public CommonResponse<List<CustomExtensionResponse>> getAllCustomExtensions() {
        return CommonResponse.ok(customExtensionService.getAllCustomExtensions());
    }

    @DeleteMapping
    public void deleteFixedExtension(@Valid @RequestBody CustomExtensionRequest request) {
        customExtensionService.deleteCustomExtension(request);
    }
}
