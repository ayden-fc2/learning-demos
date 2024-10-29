package com.example.file2075.controller;

import com.example.common.dto.ResponseBean;
import com.example.file2075.service.FileService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fs;

    @PostMapping("/defaultUploadFile")    //默认上传文件，UUID命名，default/后缀名桶
    public ResponseBean defaultUpLoadFile(@RequestBody MultipartFile file, @Param("ifCompressImg") int ifCompressImg, @Param("maxSize") int maxSize){
        try{
            String result = fs.defaultUploadFile(file, ifCompressImg, maxSize);
            if (result.equals("error")){
                return ResponseBean.fail("服务器响应错误");
            } else {
                return ResponseBean.success(result);
            }
        }catch (Exception e){
            return ResponseBean.fail(e.getMessage());
        }
    }

    @PostMapping("customUploadFile")  //指定名和桶
    public ResponseBean customUpLoadFile(@RequestBody MultipartFile file, @Param("ifCompressImg") int ifCompressImg, @Param("maxSize") int maxSize, @Param("fileName") String fileName, @Param("position") String position){
        try{
            String result = fs.customUploadFile(file, ifCompressImg, maxSize, fileName, position);
            if (result.equals("error")){
                return ResponseBean.fail("服务器响应错误");
            } else {
                return ResponseBean.success(result);
            }
        }catch (Exception e){
            return ResponseBean.fail(e.getMessage());
        }
    }


}
