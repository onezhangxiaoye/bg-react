package com.react.controller;

import com.react.entity.BlogType;
import com.react.service.BlogTypeService;
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
 * @date 2019/5/24 16:17
 */
@Controller
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/BlogTypeController")
public class BlogTypeController {

    @Autowired
    private BlogTypeService blogTypeService;


    /**查询当前博客类型配置
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    Map selectAll(HttpServletRequest request) {

        List<BlogType> blogTypeList = blogTypeService.selectAll(0);
        return ResponseData.creatResponseData(blogTypeList);
    }

}

