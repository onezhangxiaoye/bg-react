package com.react.entity;

import java.time.LocalDateTime;

/**
 * Blogs
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/05/22 09:54
 */
public class Blogs {
    private int     blogId       ; //'ID',
    private int     userId       ; //'博客对应的用户名',
    private int     blogTypeId   ; //对应得博客分类ID
    private String  blogFileName; //'博客对应的文件名',
    private String  blogTitle    ; //'博客标题',
    private String  blogContent; // 博客的概括性内容
    private LocalDateTime blogTimestamp; //'博客发布的当前时间',
    private int blogStatus    ; //博客状态 0:正常状态 1:已删除
    private String  reserve      ; //'备用字段',

    public Blogs() {
    }

    public Blogs(int userId, int blogTypeId, String blogFileName, String blogTitle, String blogContent, LocalDateTime blogTimestamp, int blogStatus) {
        this.userId = userId;
        this.blogTypeId = blogTypeId;
        this.blogFileName = blogFileName;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogTimestamp = blogTimestamp;
        this.blogStatus = blogStatus;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBlogFileName() {
        return blogFileName;
    }

    public void setBlogFileName(String blogFileName) {
        this.blogFileName = blogFileName;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public LocalDateTime getBlogTimestamp() {
        return blogTimestamp;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public void setBlogTimestamp(LocalDateTime blogTimestamp) {
        this.blogTimestamp = blogTimestamp;
    }

    public int getBlogTypeId() {
        return blogTypeId;
    }

    public void setBlogTypeId(int blogTypeId) {
        this.blogTypeId = blogTypeId;
    }

    public int getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(int blogStatus) {
        this.blogStatus = blogStatus;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

}
