package com.sini.blocking_extensions.common;

import com.sini.blocking_extensions.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "CommonService")
public class CommonService {

    private final ExtensionService extensionService;

//    public void findExtension(String name) {
//        if (extensionService.isDuplicateExtension(name)) {
//            throw new CustomException(ErrorCode.DUPLICATE_EXTENSION);
//        }
//    }
}
