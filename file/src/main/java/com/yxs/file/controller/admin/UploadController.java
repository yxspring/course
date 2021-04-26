package com.yxs.file.controller.admin;

import com.yxs.server.dto.FileDto;
import com.yxs.server.enums.FileUseEnum;
import com.yxs.server.service.FileService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RequestMapping("/admin")
@RestController
public class UploadController {
    private static final Logger log= LoggerFactory.getLogger(UploadController.class);
    private static final String BUSINESS_NAME = "文件上传";

    @Resource
    private FileService fileService;

    @Value("${file.path}")
    private String FILE_PATH;
    @Value("${file.domain}")
    private String FILE_DOMAIN;
    @RequestMapping("/upload")
    public ResponseDto upload(@RequestParam MultipartFile file,String use) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        String key=UuidUtil.getShortUuid();
        String fileName=file.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
        log.info(file.getOriginalFilename());
        log.info(String.valueOf(file.getSize()));
        //保存文件到本地
        FileUseEnum useEnum = FileUseEnum.getByCode(use);
        //如果文件夹不存在就创建
        String dir=useEnum.name().toLowerCase();
        File fullDir = new File(FILE_PATH + dir);
        if (!fullDir.exists()){
            fullDir.mkdir();
        }
        String path=dir+File.separator+key+"."+suffix;
        String fullPath=FILE_PATH+path;
        File dest = new File(fullPath);
        file.transferTo(dest);
        log.info("保存文件上传记录开始：");
        FileDto fileDto = new FileDto();
        fileDto.setPath(path);
        fileDto.setName(fileName);
        fileDto.setSize(Math.toIntExact(file.getSize()));
        fileDto.setSuffix(suffix);
        fileDto.setUse(use);
        fileService.save(fileDto);
        fileDto.setPath(FILE_DOMAIN+path);
        responseDto.setContent(fileDto);
        return responseDto;
    }
}
