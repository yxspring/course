package com.yxs.business.controller.admin;
import com.yxs.server.dto.${Domain}Dto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.exception.ValidatorException;
import com.yxs.server.service.${Domain}Service;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {
    private static final Logger Log = LoggerFactory.getLogger(${Domain}Controller.class);
    private static final String BUSINESS_NAME="大章";
    @Resource
    private ${Domain}Service ${domain}Service;
    /**
     * 查询大章列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        ${domain}Service.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    /**
     * 保存大章
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto){
        
        ResponseDto responseDto=new ResponseDto();
        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }
    /**
     * 删除大章
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        ${domain}Service.delete(id);
        return responseDto;
    }

}
