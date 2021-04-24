package com.yxs.file.controller.admin;
import com.yxs.server.dto.FileDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.service.FileService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    /**
     * 保存文件
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody FileDto fileDto){
        // 保存校验
            ValidatorUtil.require(fileDto.getPath(), "相对路径");
            ValidatorUtil.length(fileDto.getPath(), "相对路径", 1, 100);
            ValidatorUtil.length(fileDto.getName(), "文件名", 1, 100);
            ValidatorUtil.length(fileDto.getSuffix(), "后缀", 1, 10);
        ResponseDto responseDto=new ResponseDto();
        fileService.save(fileDto);
        responseDto.setContent(fileDto);
        return responseDto;
    }
    /**
     * 删除文件
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        fileService.delete(id);
        return responseDto;
    }

}
