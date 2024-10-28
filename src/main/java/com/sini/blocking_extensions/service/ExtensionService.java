package com.sini.blocking_extensions.service;

import com.sini.blocking_extensions.repository.CustomExtensionRepository;
import com.sini.blocking_extensions.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "ExtensionService")
public class ExtensionService {

    private final FixedExtensionRepository fixedExtensionRepository;
    private final CustomExtensionRepository customExtensionRepository;

    public boolean isDuplicateExtension(String name) {
        return fixedExtensionRepository.findByExtensionName(name) != null ||
            customExtensionRepository.findByCustomExtensionName(name) != null;
    }
}
