package com.yxs.business.controller.admin;

import com.yxs.server.dto.PageDto;
import com.yxs.server.dto.TeacherDto;
import com.yxs.server.service.TeacherService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/admin/teacher")
public class TeacherController {
    private static final Logger Log = LoggerFactory.getLogger(TeacherController.class);
    private static final String BUSINESS_NAME="讲师";
    @Resource
    private TeacherService teacherService;
    /**
     * 查询讲师列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        teacherService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    /**
     * 保存讲师
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody TeacherDto teacherDto){
        // 保存校验
            ValidatorUtil.length(teacherDto.getName(), "姓名", 1, 50);
            ValidatorUtil.length(teacherDto.getNickname(), "昵称", 1, 50);
            ValidatorUtil.length(teacherDto.getImage(), "头像", 1, 100);
            ValidatorUtil.length(teacherDto.getPosition(), "职位", 1, 50);
            ValidatorUtil.length(teacherDto.getMotto(), "座右铭", 1, 50);
            ValidatorUtil.length(teacherDto.getIntro(), "简介", 1, 500);
        ResponseDto responseDto=new ResponseDto();
        teacherService.save(teacherDto);
        responseDto.setContent(teacherDto);
        return responseDto;
    }
    /**
     * 删除讲师
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        teacherService.delete(id);
        return responseDto;
    }
    /**
     * 查询所有的讲师
     * */
    @PostMapping("/all")
    public ResponseDto all(){
        ResponseDto responseDto=new ResponseDto();
        List<TeacherDto> allTeacherList=teacherService.all();
        responseDto.setContent(allTeacherList);
        return responseDto;
    }
}
