package com.yxs.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxs.server.domain.CourseContentFile;
import com.yxs.server.domain.CourseContentFileExample;
import com.yxs.server.dto.CourseContentFileDto;
import com.yxs.server.dto.PageDto;
import com.yxs.server.mapper.CourseContentFileMapper;
import com.yxs.server.util.CopyUtil;
import com.yxs.server.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CourseContentFileService {

 @Resource
    private CourseContentFileMapper courseContentFileMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        CourseContentFileExample courseContentFileExample = new CourseContentFileExample();
        List<CourseContentFile> courseContentFileList = courseContentFileMapper.selectByExample(courseContentFileExample);
        PageInfo<CourseContentFile> pageInfo = new PageInfo<>(courseContentFileList);
        pageDto.setTotal(pageInfo.getTotal());
        List<CourseContentFileDto> courseContentFileDtoList = CopyUtil.copy(courseContentFileList, CourseContentFileDto.class);
        pageDto.setList(courseContentFileDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CourseContentFileDto courseContentFileDto) {
        CourseContentFile courseContentFile = CopyUtil.copy(courseContentFileDto, CourseContentFile.class);
        if (StringUtils.isEmpty(courseContentFileDto.getId())) {
            this.insert(courseContentFile);
        } else {
            this.update(courseContentFile);
        }
    }

    /**
     * 新增
     */
    private void insert(CourseContentFile courseContentFile) {
        courseContentFile.setId(UuidUtil.getShortUuid());
        courseContentFileMapper.insert(courseContentFile);
    }

    /**
     * 更新
     */
    private void update(CourseContentFile courseContentFile) {
        courseContentFileMapper.updateByPrimaryKey(courseContentFile);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        courseContentFileMapper.deleteByPrimaryKey(id);
    }

}