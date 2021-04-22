package com.yxs.file.controller.admin;

import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping("/admin")
@RestController
public class UploadController {
    private static final Logger log= LoggerFactory.getLogger(UploadController.class);
    private static final String BUSINESS_NAME = "文件上传";

    @Value("${file.path}")
    private String FILE_PATH;
    @Value("${file.domain}")
    private String FILE_DOMAIN;
    @RequestMapping("/upload")
    public ResponseDto upload(@RequestParam MultipartFile file ) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        log.info("文件开始上传:{}",file);
        log.info(file.getOriginalFilename());
        log.info(String.valueOf(file.getSize()));
        //保存文件到本地
        String fileName=file.getOriginalFilename();
        String key=UuidUtil.getShortUuid();
        String fullPath=FILE_PATH+"teacher/"+key+"-"+fileName;
        File dest = new File(fullPath);
        file.transferTo(dest);
        log.info(dest.getAbsolutePath());
        responseDto.setContent(FILE_DOMAIN+"f/teacher/"+key+"-"+fileName);
        return responseDto;
    }
}