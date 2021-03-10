package com.yxs.business.controller.admin;
import com.yxs.server.dto.ChapterDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.service.ChapterService;
import com.yxs.server.util.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    private static final Logger Log = LoggerFactory.getLogger(ChapterController.class);
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
        ResponseDto responseDto=new ResponseDto();
        try{
            chapterService.save(chapterDto);
        }catch (Exception e){
            Log.error("保存大章出错："+e.toString());
            responseDto.setSuccess(false);
        }
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
