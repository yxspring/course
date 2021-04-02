package com.yxs.business.controller.admin;
import com.yxs.server.dto.*;
import com.yxs.server.service.CourseCategoryService;
import com.yxs.server.service.CourseService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/admin/course")
public class CourseController {
    private static final Logger Log = LoggerFactory.getLogger(CourseController.class);
    private static final String BUSINESS_NAME="课程";
    @Resource
    private CourseService courseService;
    @Resource
    private CourseCategoryService courseCategoryService;
    /**
     * 查询课程列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        courseService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    /**
     * 保存课程
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseDto courseDto){
        // 保存校验
            ValidatorUtil.length(courseDto.getName(), "名称", 1, 50);
            ValidatorUtil.length(courseDto.getSummary(), "概述", 1, 2000);
            ValidatorUtil.length(courseDto.getImage(), "封面", 1, 100);
        ResponseDto responseDto=new ResponseDto();
        courseService.save(courseDto);
        responseDto.setContent(courseDto);
        return responseDto;
    }
    /**
     * 删除课程
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        courseService.delete(id);
        return responseDto;
    }
    /**
     * 查找课程下所有分类
     * */
    @PostMapping("/list-category/{courseId}")
    public ResponseDto listCategory(@PathVariable(value = "courseId") String courseId){
        ResponseDto responseDto = new ResponseDto();
        List<CourseCategoryDto> dtoList = courseCategoryService.listByCourseId(courseId);
        responseDto.setContent(dtoList);
        return responseDto;
    }
    /*查询某课程的内容*/
    @GetMapping("/find-content/{id}")
    public ResponseDto findContent(@PathVariable(value = "id") String id){
        ResponseDto responseDto = new ResponseDto();
        CourseContentDto content = courseService.findContent(id);
        responseDto.setContent(content);
        return responseDto;
    }
    /**
     * 保存某课程的内容
     * */
    @PostMapping("/save-content")
    public ResponseDto saveContent(@RequestBody CourseContentDto contentDto){
        ResponseDto responseDto = new ResponseDto();
        courseService.saveContent(contentDto);
        return responseDto;
    }
    /*更新排序*/
    @PostMapping("/sort")
    public ResponseDto sort(@RequestBody SortDto sortDto){
        Log.info("更新排序");
        ResponseDto responseDto=new ResponseDto();
        courseService.sort(sortDto);
        return responseDto;
    }
}
