package com.yxs.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxs.server.domain.CourseCategory;
import com.yxs.server.domain.CourseCategoryExample;
import com.yxs.server.dto.CategoryDto;
import com.yxs.server.dto.CourseCategoryDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.mapper.CourseCategoryMapper;
import com.yxs.server.util.CopyUtil;
import com.yxs.server.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseCategoryService {

 @Resource
    private CourseCategoryMapper courseCategoryMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        CourseCategoryExample courseCategoryExample = new CourseCategoryExample();
        List<CourseCategory> courseCategoryList = courseCategoryMapper.selectByExample(courseCategoryExample);
        PageInfo<CourseCategory> pageInfo = new PageInfo<>(courseCategoryList);
        pageDto.setTotal(pageInfo.getTotal());
        List<CourseCategoryDto> courseCategoryDtoList = CopyUtil.copy(courseCategoryList, CourseCategoryDto.class);
        pageDto.setList(courseCategoryDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CourseCategoryDto courseCategoryDto) {
        CourseCategory courseCategory = CopyUtil.copy(courseCategoryDto, CourseCategory.class);
        if (StringUtils.isEmpty(courseCategoryDto.getId())) {
            this.insert(courseCategory);
        } else {
            this.update(courseCategory);
        }
    }

    /**
     * 新增
     */
    private void insert(CourseCategory courseCategory) {
        courseCategory.setId(UuidUtil.getShortUuid());
        courseCategoryMapper.insert(courseCategory);
    }

    /**
     * 更新
     */
    private void update(CourseCategory courseCategory) {
        courseCategoryMapper.updateByPrimaryKey(courseCategory);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        courseCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
    *批量保存课程分类
    */
    @Transactional
    public void savaBatch(String courseId, List<CategoryDto>dtoList){
        CourseCategoryExample example = new CourseCategoryExample();
        example.createCriteria().andCourseIdEqualTo(courseId);
        courseCategoryMapper.deleteByExample(example);

        for (CategoryDto cd:dtoList){
            CourseCategory courseCategory = new CourseCategory();
            courseCategory.setId(UuidUtil.getShortUuid());
            courseCategory.setCourseId(courseId);
            courseCategory.setCategoryId(cd.getId());
            insert(courseCategory);
        }
    }
    /*根据某一课程Id查询该课程的分类*/
    public List<CourseCategoryDto> listByCourseId(String courseId){
        CourseCategoryExample example = new CourseCategoryExample();
        example.createCriteria().andCourseIdEqualTo(courseId);
        List<CourseCategory> courseCategoryList = courseCategoryMapper.selectByExample(example);
        return CopyUtil.copy(courseCategoryList,CourseCategoryDto.class);
    }
}