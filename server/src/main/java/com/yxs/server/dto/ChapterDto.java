package com.yxs.server.dto;

public class ChapterDto {
    private String id;

    private String courseId;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChapterDto{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}