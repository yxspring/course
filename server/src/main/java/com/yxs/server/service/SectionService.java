package com.yxs.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxs.server.domain.Section;
import com.yxs.server.domain.SectionExample;
import com.yxs.server.dto.SectionDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.mapper.SectionMapper;
import com.yxs.server.util.CopyUtil;
import com.yxs.server.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service
public class SectionService {

    @Resource
    private SectionMapper sectionMapper;
    /*
    * 大章查询
    * */
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getPageSize());
        SectionExample sectionExample = new SectionExample();
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section>pageInfo=new PageInfo<Section>(sectionList);
        pageDto.setTotal(pageInfo.getTotal());
        List<SectionDto> sectionDtoList= CopyUtil.copy(sectionList,SectionDto.class);
        pageDto.setList(sectionDtoList);
    }
    /*
    * 大章保存
    * */
    public void save(SectionDto sectionDto){
        Section section=CopyUtil.copy(sectionDto,Section.class);
        if (StringUtils.isEmpty(sectionDto.getId())){
            this.insert(section);
        }else{
            this.update(section);
        }
    }
    /*插入*/
    private void insert(Section section){
        section.setId(UuidUtil.getShortUuid());

        sectionMapper.insert(section);
    }
    /*更新*/
    private void update(Section section){
        sectionMapper.updateByPrimaryKey(section);
    }
    /*
    * 删除大章
    * */
    public  void delete(String id){
        sectionMapper.deleteByPrimaryKey(id);
    }

}