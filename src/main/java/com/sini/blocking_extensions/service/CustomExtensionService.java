package com.sini.blocking_extensions.service;

import com.sini.blocking_extensions.common.CommonService;
import com.sini.blocking_extensions.dto.CustomExtensionRequest;
import com.sini.blocking_extensions.entity.CustomExtension;
import com.sini.blocking_extensions.entity.FixedExtension;
import com.sini.blocking_extensions.global.exception.custom.ExtensionLimitExceededException;
import com.sini.blocking_extensions.repository.CustomExtensionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j(topic = "CustomExtensionService")
public class CustomExtensionService {

    private final CustomExtensionRepository customExtensionRepository;
    private final CommonService commonService;

    public void setCustomExtension(CustomExtensionRequest request) {
        commonService.validateNonDuplicateExtension(request.getExtensionName());

        List<CustomExtension> customExtensions = customExtensionRepository.findAll();
        if(customExtensions.size() <= 200) {
            throw new ExtensionLimitExceededException("확장자를 더 이상 추가할 수 없습니다. 확장자는 200개까지 저장할 수 있습니다.");
        }

        CustomExtension customExtension = new CustomExtension(request.getExtensionName());
        customExtensionRepository.save(customExtension);
    }
}
