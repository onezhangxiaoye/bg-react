package com.react.pojo;

import com.react.entity.Blogs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogsMapper {

    /**插入一条 博客 信息数据
     *
     * @param blog 图片对象
     * @return 某一个对象
     */
    void addBlog(Blogs blog);

    /**查询某个用户的 博客信息
     *
     * @param userId 需要查询的用户id
     * @param blogTypeId
     * @param blogStatus
     * @return 返回博客对象集合
     */
    List<Blogs> selectBlogsByUserId(int userId,int blogTypeId,int blogStatus);

    /**通过博客id查询博客详细信息
     *
     * @param blogId 需要查询的对应博客id
     * @return 博客实体类对象
     */
    Blogs selectBlogsByBlogId(int blogId);
}