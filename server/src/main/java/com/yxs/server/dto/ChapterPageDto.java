package com.yxs.server.dto;

public class ChapterPageDto extends PageDto {

    private String courseId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChapterPageDto{");
        sb.append("page=").append(page);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", list=").append(list);
        sb.append(", courseId='").append(courseId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
