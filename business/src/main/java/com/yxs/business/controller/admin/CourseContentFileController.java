package com.yxs.business.controller.admin;
import com.yxs.server.dto.CourseContentFileDto;
import com.yxs.server.service.CourseContentFileService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/admin/course-content-file")
public class CourseContentFileController {
    private static final Logger Log = LoggerFactory.getLogger(CourseContentFileController.class);
    private static final String BUSINESS_NAME="课程内容文件";
    @Resource
    private CourseContentFileService courseContentFileService;
    /**
     * 查询课程内容文件列表
     * */
    @GetMapping("/list/{courseId}")
    public ResponseDto list(@PathVariable String courseId){
        ResponseDto responseDto=new ResponseDto();
        List<CourseContentFileDto> list = courseContentFileService.list(courseId);
        responseDto.setContent(list);
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
