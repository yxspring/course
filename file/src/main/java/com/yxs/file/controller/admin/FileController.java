package com.yxs.file.controller.admin;
import com.yxs.server.dto.PageDto;
import com.yxs.server.service.FileService;
import com.yxs.server.util.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/file")
public class FileController {
    private static final Logger Log = LoggerFactory.getLogger(FileController.class);
    private static final String BUSINESS_NAME="文件";
    @Resource
    private FileService fileService;
    /**
     * 查询文件列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        fileService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
}
