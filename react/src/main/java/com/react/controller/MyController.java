package com.react.controller;

import com.react.entity.Img;
import com.react.entity.User;
import com.react.service.ImgService;
import com.react.service.UserService;
import com.react.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 1 1
 */
@Controller
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/MyController")
public class MyController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImgService imgService;

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    Map home(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println(userId);
        User user = userService.selectByPrimaryKey(userId);
        return ResponseData.creatResponseData(user);
    }

    /**
     *
     * @return
     */
    @RequestMapping("/selectAllData")
    @ResponseBody
    Map selectAllData() {
        List<User> userList = userService.selectAllData();
        return ResponseData.creatResponseData(userList);
    }

    /**
     *
     * @return
     */
    @RequestMapping("/selectAllImg")
    @ResponseBody
    Map selectAllImg() {
        List<Img> imgList = imgService.selectAllImg();
        return ResponseData.creatResponseData(imgList);
    }



    /**
     *
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "{\"message\":\"success\"}";
    }

}

