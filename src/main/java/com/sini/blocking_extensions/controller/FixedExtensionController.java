package com.sini.blocking_extensions.controller;

import com.sini.blocking_extensions.dto.FixedExtensionRequest;
import com.sini.blocking_extensions.service.FixedExtensionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/extension")
public class FixedExtensionController {

    private final FixedExtensionService fixedExtensionService;

    @PostMapping
    public void setFixedExtension(@Valid @RequestBody FixedExtensionRequest request
    ) { fixedExtensionService.setFixedExtension(request);
    }

}
