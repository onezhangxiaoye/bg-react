package com.react.controller;

import com.react.entity.User;
import com.react.service.UserService;
import com.react.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/29
 */
@Controller
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;



    /**根据用户名查询用户数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectByUserName")
    @ResponseBody
    Map selectByUserName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        User user = userService.selectByUserName(name);
        if (user == null){
            return ResponseData.creatResponseDataError("未找到该用户");
        }else if (!password.equals(user.getPassword())){
            return ResponseData.creatResponseDataError("密码错误");
        }
        return ResponseData.creatResponseData(user);
    }

    /**用户注册
     *
     * @param request
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    Map register(HttpServletRequest request) {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = userService.selectByUserName(name);
        //判断用户名是否被使用
        if (user != null){
            return ResponseData.creatResponseDataError("用户名被占用啦！");
        }else {
            user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            int i = userService.register(user);
            System.out.println(i);
            return ResponseData.creatResponseData(user);
        }
    }

}

