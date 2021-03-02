package com.yxs.server.service;

import com.yxs.server.domain.Chapter;
import com.yxs.server.domain.ChapterExample;
import com.yxs.server.mapper.ChapterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public List<Chapter> list(){

        ChapterExample chapterExample = new ChapterExample();
        chapterExample.createCriteria().andIdEqualTo("1");
        chapterExample.setOrderByClause(" id desc");
        return chapterMapper.selectByExample(chapterExample);
    }
}
