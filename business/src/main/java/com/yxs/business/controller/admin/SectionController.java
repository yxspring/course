package com.yxs.business.controller.admin;
import com.yxs.server.dto.SectionDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.exception.ValidatorException;
import com.yxs.server.service.SectionService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/section")
public class SectionController {
    private static final Logger Log = LoggerFactory.getLogger(SectionController.class);
    private static final String BUSINESS_NAME="小节";
    @Resource
    private SectionService sectionService;
    /**
     * 查询大章列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        sectionService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    /**
     * 保存大章
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto){

        ResponseDto responseDto=new ResponseDto();
        sectionService.save(sectionDto);
        responseDto.setContent(sectionDto);
        return responseDto;
    }
    /**
     * 删除大章
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        sectionService.delete(id);
        return responseDto;
    }

}
