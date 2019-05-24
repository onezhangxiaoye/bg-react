package com.react.service;

import com.react.entity.Blogs;
import com.react.pojo.BlogsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/5/22 10:05
 */
@Service
public class BlogsService implements BlogsMapper {


    @Autowired
    private BlogsMapper blogsMapper;

    @Override
    public void addBlog(Blogs blog) {
        blogsMapper.addBlog(blog);
    }

    @Override
    public List<Blogs> selectBlogsByUserId(int userId,int blogTypeId,int blogStatus) {
        return blogsMapper.selectBlogsByUserId(userId,blogTypeId,blogStatus);
    }

    @Override
    public Blogs selectBlogsByBlogId(int blogId) {
        return blogsMapper.selectBlogsByBlogId(blogId);
    }
}
