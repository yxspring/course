package com.yxs.business.controller.admin;
import com.yxs.server.dto.CourseContentFileDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.service.CourseContentFileService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/courseContentFile")
public class CourseContentFileController {
    private static final Logger Log = LoggerFactory.getLogger(CourseContentFileController.class);
    private static final String BUSINESS_NAME="课程内容文件";
    @Resource
    private CourseContentFileService courseContentFileService;
    /**
     * 查询课程内容文件列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        courseContentFileService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    /**
     * 保存课程内容文件
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseContentFileDto courseContentFileDto){
        // 保存校验
            ValidatorUtil.require(courseContentFileDto.getCourseId(), "课程id");
            ValidatorUtil.length(courseContentFileDto.getUrl(), "地址", 1, 100);
            ValidatorUtil.length(courseContentFileDto.getName(), "文件名", 1, 100);
        ResponseDto responseDto=new ResponseDto();
        courseContentFileService.save(courseContentFileDto);
        responseDto.setContent(courseContentFileDto);
        return responseDto;
    }
    /**
     * 删除课程内容文件
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        courseContentFileService.delete(id);
        return responseDto;
    }

}
