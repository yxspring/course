package com.yxs.business.controller.admin;
import com.yxs.server.dto.SectionDto;
import com.yxs.server.dto.SectionPageDto;
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
     * 查询小节列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody SectionPageDto sectionPageDto){
        ResponseDto responseDto=new ResponseDto();
        ValidatorUtil.require(sectionPageDto.getCourseId(),"课程ID");
        ValidatorUtil.require(sectionPageDto.getChapterId(),"大章ID");
        sectionService.list(sectionPageDto);
        responseDto.setContent(sectionPageDto);
        return responseDto;
    }
    /**
     * 保存小节
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto){
        // 保存校验
            ValidatorUtil.require(sectionDto.getTitle(), "标题");
            ValidatorUtil.length(sectionDto.getTitle(), "标题", 1, 50);
            ValidatorUtil.length(sectionDto.getVideo(), "视频", 1, 200);
        ResponseDto responseDto=new ResponseDto();
        sectionService.save(sectionDto);
        responseDto.setContent(sectionDto);
        return responseDto;
    }
    /**
     * 删除小节
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        sectionService.delete(id);
        return responseDto;
    }

}
