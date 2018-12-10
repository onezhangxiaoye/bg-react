package com.react.impl;

import com.react.entity.User;

public interface UserServiceImpl {

    public User getUserById(int userId);

    boolean addUser(User record);
}
