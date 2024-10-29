package com.example.file2075.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String defaultUploadFile(MultipartFile file, int ifCompressImg, int maxSize);


    String customUploadFile(MultipartFile file, int ifCompressImg, int maxSize, String fileName, String position);
}
