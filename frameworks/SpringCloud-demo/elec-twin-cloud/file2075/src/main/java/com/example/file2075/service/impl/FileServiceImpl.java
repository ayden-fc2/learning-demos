package com.example.file2075.service.impl;

import com.example.file2075.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ResourceLoader;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    ResourceLoader rl;

    @Value("${custom.file-path}")
    private String uploadFilePath;

    @Value("${custom.return-path}")
    private String returnFileUrl;

    // 默认新增文件default
    @Override
    public String defaultUploadFile(MultipartFile file, int ifCompressImg, int maxSize) {
        try {
            String originalFileName = file.getOriginalFilename();
            //文件压缩
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            if ((fileExtension.equals("png")||fileExtension.equals("jpg"))&&ifCompressImg==1){
                file = ImageUtil.compressImage(maxSize * 1024, file);
            }
            String newFilename = UUID.randomUUID().toString() + "." + fileExtension;
            // 指定绝对路径
            String saveDirectory = uploadFilePath + "default/" + fileExtension + "/";
            Path savePath = Paths.get(saveDirectory, newFilename); // 使用 Paths.get 创建路径
            Files.createDirectories(savePath.getParent());
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, savePath, StandardCopyOption.REPLACE_EXISTING);
            }
            String baseUrl = returnFileUrl + "default/" + fileExtension + "/";
            String fileUrl = baseUrl + newFilename;
            return fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String customUploadFile(MultipartFile file, int ifCompressImg, int maxSize, String fileName, String position) {
        try {
            String originalFileName = file.getOriginalFilename();
            //文件压缩
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            if ((fileExtension.equals("png")||fileExtension.equals("jpg"))&&ifCompressImg==1){
                file = ImageUtil.compressImage(maxSize * 1024, file);
            }
            String newFilename = fileName + "." + fileExtension;
            // 指定绝对路径
            String saveDirectory = uploadFilePath + position + "/";
            Path savePath = Paths.get(saveDirectory, newFilename); // 使用 Paths.get 创建路径
            Files.createDirectories(savePath.getParent());
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, savePath, StandardCopyOption.REPLACE_EXISTING);
            }
            String baseUrl = returnFileUrl + position + "/";
            String fileUrl = baseUrl + newFilename;
            return fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


}
