package com.sini.blocking_extensions.service;

import com.sini.blocking_extensions.entity.CustomExtension;
import com.sini.blocking_extensions.entity.FixedExtension;
import com.sini.blocking_extensions.global.common.CommonService;
import com.sini.blocking_extensions.global.exception.custom.BlockedExtensionException;
import com.sini.blocking_extensions.global.exception.custom.FileSizeLimitException;
import com.sini.blocking_extensions.global.exception.custom.NotFoundExtensionException;
import com.sini.blocking_extensions.global.exception.custom.NotFoundFileException;
import com.sini.blocking_extensions.global.exception.custom.NotMatchedExtensionNameException;
import com.sini.blocking_extensions.repository.FileRepository;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "FileService")
public class FileService {

    private final FileRepository fileRepository;
    private final CommonService commonService;
//    private final FileUploadService fileUploadService;

    public String saveFile(MultipartFile file) {
        float megabytes = (float) file.getSize() / 1024 / 1024;
        if (megabytes > 10) {
            throw new FileSizeLimitException("파일 용량이 초과되었습니다. 10MB 이하의 파일만 업로드 해주세요.");
        }

        if (file.isEmpty()) {
            throw new NotFoundFileException("파일을 올리지 않고 요청하셨습니다. 파일을 업로드 해주세요.");
        }

        validateAndExtractExtension(file);
        String keyName = createKeyName(file);

//        try {
//            String filePath = fileUploadService.upload(file, keyName);
//            Long fileId = fileRepository.save(new File(objectName, keyName, filePath, user)).getId();
//            return new FileCreateResponseDto(fileId);
//        } catch (IOException e) {
//            throw new IllegalArgumentException();
//        }
        return "완성";
    }

    private void validateAndExtractExtension(MultipartFile file) {
        if (!file.getOriginalFilename().contains(".") || !file.getContentType().contains("/")) {
            throw new NotFoundExtensionException("확장자가 존재하지 않는 파일입니다.");
        }

        String extractedExtension = file.getOriginalFilename()
            .substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        // 해당 확장자가 차단되어 있는지 여부
        commonService.validateBlockedExtension(extractedExtension);
        // 확장자가 알맞은 형식인지 검증
        validateExtensionFormat(extractedExtension);
    }

    private void validateExtensionFormat(String extension) {
        if (!extension.matches("^[a-zA-Z]*$")) {
            throw new NotMatchedExtensionNameException("영문 확장자가 아닌 확장자는 접근할 수 없습니다. (ex. 공백, 숫자, 한글)");
        }
    }

    private String createKeyName(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        String filename = file.getOriginalFilename(); // 공백제거 옥 장 판
        return filename + uuid;
    }

}
