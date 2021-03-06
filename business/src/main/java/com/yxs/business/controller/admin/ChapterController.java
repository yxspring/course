package com.yxs.business.controller.admin;
import com.yxs.server.dto.ChapterDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    private static final Logger Log = LoggerFactory.getLogger(ChapterController.class);
    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public PageDto list(@RequestBody PageDto pageDto){
        Log.info("pageDto:{}",pageDto);
        chapterService.list(pageDto);
        return pageDto;
    }
}
