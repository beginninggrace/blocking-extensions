package com.sini.blocking_extensions.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String upload(MultipartFile auctionImage, String keyName) throws IOException;

    void delete(String keyName);

    /**
     * 외부인이 URL을 통해 S3에 업로드된 파일을 특정 시간동안 임시적으로 접근 가능(다운로드)
     *
     * @return 파일 Id, preSignedUrl
     */
    String getPresignedURL(String keyName);


}

