package com.react.service;

import com.react.entity.User;
import com.react.pojo.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/6 22:37
 */
@Service
public class UserService implements UserMapper {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAllData() {
        return userMapper.selectAllData();
    }
}
