package com.react.controller;

import com.react.utils.ResponseData;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/5/20 11:18
 */
@Controller
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/TetsController")
public class TetsController {

    /** 单图片上传
     *
     * @param
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    Map test() {

        System.out.println("请求成功");
        return ResponseData.creatResponseDataError("请求成功");
    }
}
