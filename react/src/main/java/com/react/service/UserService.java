package com.react.service;

import com.react.dao.UserMapper;
import com.react.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/6 22:37
 */
@Service("userService")
public class UserService implements UserMapper {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
