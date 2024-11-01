package com.sini.blocking_extensions.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String upload(MultipartFile auctionImage, String keyName) throws IOException;

}

