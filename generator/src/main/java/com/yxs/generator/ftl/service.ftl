package com.yxs.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxs.server.domain.${Domain};
import com.yxs.server.domain.${Domain}Example;
import com.yxs.server.dto.${Domain}Dto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.mapper.${Domain}Mapper;
import com.yxs.server.util.CopyUtil;
import com.yxs.server.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ${Domain}Service {

    @Resource
    private ${Domain}Mapper ${domain}Mapper;
    /*
    * 大章查询
    * */
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getPageSize());
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        List<${Domain}> ${domain}List = ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}>pageInfo=new PageInfo<${Domain}>(${domain}List);
        pageDto.setTotal(pageInfo.getTotal());
        List<${Domain}Dto> ${domain}DtoList= CopyUtil.copy(${domain}List,${Domain}Dto.class);
        pageDto.setList(${domain}DtoList);
    }
    /*
    * 大章保存
    * */
    public void save(${Domain}Dto ${domain}Dto){
        ${Domain} ${domain}=CopyUtil.copy(${domain}Dto,${Domain}.class);
        if (StringUtils.isEmpty(${domain}Dto.getId())){
            this.insert(${domain});
        }else{
            this.update(${domain});
        }
    }
    /*插入*/
    private void insert(${Domain} ${domain}){
        ${domain}.setId(UuidUtil.getShortUuid());

        ${domain}Mapper.insert(${domain});
    }
    /*更新*/
    private void update(${Domain} ${domain}){
        ${domain}Mapper.updateByPrimaryKey(${domain});
    }
    /*
    * 删除大章
    * */
    public  void delete(String id){
        ${domain}Mapper.deleteByPrimaryKey(id);
    }

}