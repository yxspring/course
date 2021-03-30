package com.yxs.business.controller.admin;
import com.yxs.server.dto.CourseCategoryDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.exception.ValidatorException;
import com.yxs.server.service.CourseCategoryService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/courseCategory")
public class CourseCategoryController {
    private static final Logger Log = LoggerFactory.getLogger(CourseCategoryController.class);
    private static final String BUSINESS_NAME="课程分类";
    @Resource
    private CourseCategoryService courseCategoryService;
    /**
     * 查询课程分类列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        courseCategoryService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    /**
     * 保存课程分类
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseCategoryDto courseCategoryDto){
        // 保存校验
        ResponseDto responseDto=new ResponseDto();
        courseCategoryService.save(courseCategoryDto);
        responseDto.setContent(courseCategoryDto);
        return responseDto;
    }
    /**
     * 删除课程分类
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        courseCategoryService.delete(id);
        return responseDto;
    }

}
