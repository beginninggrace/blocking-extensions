package com.sini.blocking_extensions.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.sini.blocking_extensions.global.exception.custom.NotFoundBucketException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "S3Service")
public class S3Service implements FileUploadService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    // final 왜?
    private AmazonS3 amazonS3;

    @Override
    public String upload(MultipartFile file, String keyName) throws IOException {
        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentType(file.getContentType());
        objMeta.setContentLength(file.getInputStream().available());

        try {
            amazonS3.putObject(bucket, keyName, file.getInputStream(), objMeta);
        } catch (AmazonS3Exception e) {
            throw new NotFoundBucketException("존재하지 않는 버킷입니다.");
        }

        return "https://dccg5mv6uel89.cloudfront.net/" + keyName;
    }

    @Override
    public void delete(String keyName) {
        try {
            amazonS3.deleteObject(bucket, keyName);
        } catch (AmazonS3Exception e) {
            throw new NotFoundBucketException("존재하지 않는 버킷입니다.");
        }
    }
}
