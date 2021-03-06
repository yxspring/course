package com.yxs.server.dto;

import java.util.List;

public class PageDto<T> {
    //当前页
    private int page;
    //每页的大小
    private int pageSize;
    //总条数
    private long total;
    //查询的结果集
    private List<T> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
