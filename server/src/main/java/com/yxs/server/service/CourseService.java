package com.yxs.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxs.server.domain.Course;
import com.yxs.server.domain.CourseExample;
import com.yxs.server.dto.CourseDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.mapper.CourseMapper;
import com.yxs.server.mapper.my.MyCourseMapper;
import com.yxs.server.util.CopyUtil;
import com.yxs.server.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    private static final Logger Log = LoggerFactory.getLogger(CourseService.class);
    @Resource
    private CourseMapper courseMapper;

    @Resource
    private MyCourseMapper myCourseMapper;

    @Resource
    private CourseCategoryService courseCategoryService;
    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        CourseExample courseExample = new CourseExample();
        courseExample.setOrderByClause("sort asc");
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        pageDto.setTotal(pageInfo.getTotal());
        List<CourseDto> courseDtoList = CopyUtil.copy(courseList, CourseDto.class);
        pageDto.setList(courseDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CourseDto courseDto) {
        Course course = CopyUtil.copy(courseDto, Course.class);
        if (StringUtils.isEmpty(courseDto.getId())) {
            this.insert(course);
        } else {
            this.update(course);
        }
        courseCategoryService.savaBatch(course.getId(),courseDto.getCategorys());
    }

    /**
     * 新增
     */
    private void insert(Course course) {
        Date now = new Date();
        course.setCreatedAt(now);
        course.setUpdatedAt(now);
        course.setId(UuidUtil.getShortUuid());
        courseMapper.insert(course);
    }

    /**
     * 更新
     */
    private void update(Course course) {
        course.setUpdatedAt(new Date());
        courseMapper.updateByPrimaryKey(course);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    /*
    更新课程时长
    * */
    public void updateTime(String courseId){
        Log.info("更新课程时长：{}",courseId);
        myCourseMapper.updateTime(courseId);
    }

}