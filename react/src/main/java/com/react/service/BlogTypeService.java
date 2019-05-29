package com.react.service;

import com.react.entity.BlogType;
import com.react.pojo.BlogTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/5/24 16:15
 */
@Service
public class BlogTypeService implements BlogTypeMapper {


    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Override
    public List<BlogType> selectAll(Integer blogTypeStatus) {
        return blogTypeMapper.selectAll(blogTypeStatus);
    }
}
