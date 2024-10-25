package com.sini.blocking_extensions.service;

import com.sini.blocking_extensions.dto.FixedExtensionRequest;
import com.sini.blocking_extensions.entity.FixedExtension;
import com.sini.blocking_extensions.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j(topic = "FixedExtensionService")
public class FixedExtensionService {

    private final FixedExtensionRepository fixedExtensionRepository;

    @Transactional
    public void setFixedExtension(FixedExtensionRequest request) {
        FixedExtension fixedExtension = new FixedExtension(request.getExtensionName());
        fixedExtensionRepository.save(fixedExtension);
    }
}
