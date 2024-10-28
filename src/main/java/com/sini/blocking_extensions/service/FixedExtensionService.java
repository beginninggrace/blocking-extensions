package com.sini.blocking_extensions.service;

import com.sini.blocking_extensions.dto.FixedExtensionRequest;
import com.sini.blocking_extensions.dto.FixedExtensionResponse;
import com.sini.blocking_extensions.entity.FixedExtension;
import com.sini.blocking_extensions.global.exception.custom.NotFoundExtensionException;
import com.sini.blocking_extensions.repository.FixedExtensionRepository;
import java.util.List;
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
        // 검증 추가해야 함
        FixedExtension fixedExtension = new FixedExtension(request.getExtensionName());
        fixedExtensionRepository.save(fixedExtension);
    }


    public List<FixedExtensionResponse> getAllFixedExtensions() {
        List<FixedExtension> fixedExtensions = fixedExtensionRepository.findAll();

        if (fixedExtensions.isEmpty()) {
            throw new NotFoundExtensionException("확장자가 존재하지 않습니다.");
        }

        return fixedExtensions.stream().map(
            fixedExtension -> new FixedExtensionResponse(fixedExtension.getExtensionName())).toList();
    }

    public void deleteFixedExtension(FixedExtensionRequest request) {
        FixedExtension deleteExtension = fixedExtensionRepository.findByExtensionName(request.getExtensionName());

        if (deleteExtension == null) {
            throw new NotFoundExtensionException("삭제할 확장자가 존재하지 않습니다.");
        }

        fixedExtensionRepository.delete(deleteExtension);
    }
}
