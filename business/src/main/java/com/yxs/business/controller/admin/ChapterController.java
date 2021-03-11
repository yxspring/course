package com.yxs.business.controller.admin;
import com.yxs.server.dto.ChapterDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.exception.ValidatorException;
import com.yxs.server.service.ChapterService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    private static final Logger Log = LoggerFactory.getLogger(ChapterController.class);
    private static final String BUSINESS_NAME="大章";
    @Resource
    private ChapterService chapterService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        Log.info("pageDto:{}",pageDto);
        ResponseDto responseDto=new ResponseDto();
        chapterService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto){
        Log.info("chapterDto:{}",chapterDto);
        ValidatorUtil.require(chapterDto.getName(),"课程名称");
        ValidatorUtil.require(chapterDto.getCourseId(),"课程ID");
        ValidatorUtil.length(chapterDto.getCourseId(),"课程ID",1,8);
        ResponseDto responseDto=new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        Log.info("id:{}",id);
        ResponseDto responseDto=new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }

}
