package com.react.pojo;

import com.react.entity.BlogType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogTypeMapper {

    /**查询对应状态的博客类型
     *
     * @param blogTypeStatus 博客状态信息
     * @return
     */
    List<BlogType> selectAll(Integer blogTypeStatus);
}