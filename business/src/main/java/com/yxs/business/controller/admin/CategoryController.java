package com.yxs.business.controller.admin;
import com.yxs.server.dto.CategoryDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.exception.ValidatorException;
import com.yxs.server.service.CategoryService;
import com.yxs.server.util.ResponseDto;
import com.yxs.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    private static final Logger Log = LoggerFactory.getLogger(CategoryController.class);
    private static final String BUSINESS_NAME="分类";
    @Resource
    private CategoryService categoryService;
    /**
     * 查询分类列表
     * */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
        categoryService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    /**
     * 保存分类
     * */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CategoryDto categoryDto){
        // 保存校验
            ValidatorUtil.require(categoryDto.getParent(), "父id");
            ValidatorUtil.require(categoryDto.getName(), "名称");
            ValidatorUtil.length(categoryDto.getName(), "名称", 1, 50);
        ResponseDto responseDto=new ResponseDto();
        categoryService.save(categoryDto);
        responseDto.setContent(categoryDto);
        return responseDto;
    }
    /**
     * 删除分类
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto=new ResponseDto();
        categoryService.delete(id);
        return responseDto;
    }

}
