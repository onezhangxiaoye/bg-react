package com.react.controller;

import com.react.entity.Img;
import com.react.entity.User;
import com.react.service.ImgService;
import com.react.service.TestService;
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

    @Autowired
    private TestService testService;

    /**根据用户id查询用户数据
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

    /**查询所有用户数据
     *
     * @return
     */
    @RequestMapping("/selectAllData")
    @ResponseBody
    Map selectAllData() {
        List<User> userList = userService.selectAllData();
        return ResponseData.creatResponseData(userList);
    }

    /**查询所有图片数据
     *
     * @return
     */
    @RequestMapping("/selectAllImg")
    @ResponseBody
    Map selectAllImg() {
        List<Img> imgList = imgService.selectAllImg();
        return ResponseData.creatResponseData(imgList);
    }



    /** 测试方法 不访问数据库
     *
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    Map test(HttpServletRequest request) {
        System.out.println(request.getParameter("comment"));
        System.out.println(request.getParameter("data"));
        System.out.println(request.getParameter("phone"));
//        Test test = new Test();
////        test.setId(1);
//        test.setName("白菜");
//        test.setDep(20);
//        test.setBirthday(30);
//        test.setPic_name("白菜.png");
//        int i;
//        try {
//            i = testService.addTest(test);
//            System.out.println(i + "---------");
//            return ResponseData.creatResponseDataError("测试请求添加数据成功");
//        }catch (Exception e){
//            return ResponseData.creatResponseDataError("保存参数时出现异常");
//        }
        return ResponseData.creatResponseDataError("测试请求添加数据成功");
    }
}

