package com.yxs.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxs.server.domain.Chapter;
import com.yxs.server.domain.ChapterExample;
import com.yxs.server.dto.ChapterDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.mapper.ChapterMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getPageSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter>pageInfo=new PageInfo<Chapter>(chapterList);
        pageDto.setTotal(pageInfo.getTotal());
        List<ChapterDto> chapterDtoList = new ArrayList<ChapterDto>();
        for (Chapter chapter:chapterList) {
            ChapterDto chapterDto=new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        pageDto.setList(chapterDtoList);
    }
}
