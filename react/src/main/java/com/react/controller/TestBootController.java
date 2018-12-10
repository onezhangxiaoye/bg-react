package com.react.controller;

import com.react.entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/6 16:40
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {
    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setName("test");
        return user;
    }
}
