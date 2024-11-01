package com.sini.blocking_extensions.service;

import com.sini.blocking_extensions.dto.FileCreateResponse;
import com.sini.blocking_extensions.dto.FileReadResponse;
import com.sini.blocking_extensions.entity.File;
import com.sini.blocking_extensions.global.common.CommonService;
import com.sini.blocking_extensions.global.exception.custom.FileSizeLimitException;
import com.sini.blocking_extensions.global.exception.custom.FileUploadFailedException;
import com.sini.blocking_extensions.global.exception.custom.NotFoundExtensionException;
import com.sini.blocking_extensions.global.exception.custom.NotFoundFileException;
import com.sini.blocking_extensions.global.exception.custom.NotMatchedExtensionNameException;
import com.sini.blocking_extensions.repository.FileRepository;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j(topic = "FileService")
public class FileService {

    private final FileRepository fileRepository;
    private final CommonService commonService;
    private final FileUploadService fileUploadService;

    @Transactional
    public FileCreateResponse saveFile(MultipartFile file) {
        float megabytes = (float) file.getSize() / 1024 / 1024;
        if (megabytes > 10) {
            throw new FileSizeLimitException("파일 용량이 초과되었습니다. 10MB 이하의 파일만 업로드 해주세요.");
        }

        if (file.isEmpty()) {
            throw new NotFoundFileException("파일을 올리지 않고 요청하셨습니다. 파일을 업로드 해주세요.");
        }

        validateAndExtractExtension(file);

        String keyName = createKeyName(file);
        String fileType = file.getContentType().substring(file.getContentType().lastIndexOf("/") + 1);

        try {
            String filePath = fileUploadService.upload(file, keyName);
            Long fileId = fileRepository.save(new File(file.getOriginalFilename(), keyName, filePath, fileType)).getId();
            return new FileCreateResponse(fileId, file.getOriginalFilename());
        } catch (IOException e) {
            throw new FileUploadFailedException("파일 업로드에 실패했습니다. 나중에 다시 시도해주세요.");
        }
    }

    @Transactional
    public void delete(File file) {
        fileUploadService.delete(file.getKeyName());
        fileRepository.delete(file);
    }

    public FileReadResponse getPresignedURL(Long fileId) {
        File file = findFileOrElseThrow(fileId);

        String preSignedUrl = fileUploadService.getPresignedURL(file.getKeyName());
        return new FileReadResponse(file.getId(), preSignedUrl);
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
        String filename = file.getOriginalFilename();
        return filename + uuid;
    }

    public File findFileOrElseThrow(Long fileId) {
        return fileRepository.findById(fileId).orElseThrow(
            () -> new NotFoundFileException("존재하지 않는 파일입니다.")
        );
    }

}
