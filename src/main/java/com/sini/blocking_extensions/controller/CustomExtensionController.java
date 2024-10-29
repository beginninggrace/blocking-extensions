package com.sini.blocking_extensions.controller;

import com.sini.blocking_extensions.dto.CustomExtensionRequest;
import com.sini.blocking_extensions.service.CustomExtensionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/custom-extension")
public class CustomExtensionController {

    private final CustomExtensionService customExtensionService;

    @PostMapping
    public void setCustomExtension(@Valid @RequestBody CustomExtensionRequest request) {
        customExtensionService.setCustomExtension(request);
    }
}
