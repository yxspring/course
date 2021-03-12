package com.yxs.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxs.server.domain.Chapter;
import com.yxs.server.domain.ChapterExample;
import com.yxs.server.dto.ChapterDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.mapper.ChapterMapper;
import com.yxs.server.util.CopyUtil;
import com.yxs.server.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;
    /*
    * 大章查询
    * */
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getPageSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter>pageInfo=new PageInfo<Chapter>(chapterList);
        pageDto.setTotal(pageInfo.getTotal());
        List<ChapterDto> chapterDtoList= CopyUtil.copy(chapterList,ChapterDto.class);
        pageDto.setList(chapterDtoList);
    }
    /*
    * 大章保存
    * */
    public void save(ChapterDto chapterDto){
        Chapter chapter=CopyUtil.copy(chapterDto,Chapter.class);
        if (StringUtils.isEmpty(chapterDto.getId())){
            this.insert(chapter);
        }else{
            this.update(chapter);
        }
    }
    /*插入*/
    private void insert(Chapter chapter){
        chapter.setId(UuidUtil.getShortUuid());

        chapterMapper.insert(chapter);
    }
    /*更新*/
    private void update(Chapter chapter){
        chapterMapper.updateByPrimaryKey(chapter);
    }
    /*
    * 删除大章
    * */
    public  void delete(String id){
        chapterMapper.deleteByPrimaryKey(id);
    }

}
