package com.react.dao;

import com.react.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectByPrimaryKey(Integer id);
}