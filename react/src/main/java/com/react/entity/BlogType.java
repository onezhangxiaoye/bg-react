package com.react.entity;

public class BlogType {
    private Integer blogTypeId;

    private String blogTypeTitle;

    private String blogTypeDescription;

    private Integer blogTypeStatus;

    private String reserve;

    public Integer getBlogTypeId() {
        return blogTypeId;
    }

    public void setBlogTypeId(Integer blogTypeId) {
        this.blogTypeId = blogTypeId;
    }

    public String getBlogTypeTitle() {
        return blogTypeTitle;
    }

    public void setBlogTypeTitle(String blogTypeTitle) {
        this.blogTypeTitle = blogTypeTitle;
    }

    public String getBlogTypeDescription() {
        return blogTypeDescription;
    }

    public void setBlogTypeDescription(String blogTypeDescription) {
        this.blogTypeDescription = blogTypeDescription;
    }

    public Integer getBlogTypeStatus() {
        return blogTypeStatus;
    }

    public void setBlogTypeStatus(Integer blogTypeStatus) {
        this.blogTypeStatus = blogTypeStatus;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}