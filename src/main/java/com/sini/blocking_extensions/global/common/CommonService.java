package com.sini.blocking_extensions.global.common;

import com.sini.blocking_extensions.global.exception.custom.BlockedExtensionException;
import com.sini.blocking_extensions.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "CommonService")
public class CommonService {

    private final ExtensionService extensionService;

    public void validateBlockedExtension(String name) {
        if (extensionService.isDuplicateExtension(name)) {
            throw new BlockedExtensionException("해당 확장자는 차단된 확장자입니다.");
        }
    }
}
