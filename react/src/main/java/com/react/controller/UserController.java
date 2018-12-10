package com.react.controller;

import com.react.entity.User;
import com.react.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/6 21:48
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println(userId );
        User user = this.userService.selectByPrimaryKey(userId);
        return user;
    }
}
