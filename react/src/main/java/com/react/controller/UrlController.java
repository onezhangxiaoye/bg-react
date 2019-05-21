package com.react.controller;

import com.react.entity.Url;
import com.react.service.UrlService;
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
 * 系统路径相关配置 Controller
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/1/15 11:17
 */
@Controller
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/UrlController")
public class UrlController {

    @Autowired
    private UrlService urlService;



    /** 查询所有 系统路径配置数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectAllData")
    @ResponseBody
    Map selectAllData(HttpServletRequest request) {
        return ResponseData.creatResponseData(urlService.selectAllData());
    }

    /** 添加 路径配置数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/addUrl")
    @ResponseBody
    Map addUrl(HttpServletRequest request) {
        String to = request.getParameter("to");
        String name = request.getParameter("name");
        int tagFatherId = Integer.valueOf(request.getParameter("tagFatherId"));
        int number = Integer.valueOf(request.getParameter("number"));
        int hidden = Integer.valueOf(request.getParameter("hidden"));
        Url newurl = new Url(to,name,tagFatherId,number,hidden);
        //i 为受影响行数 且在插入成功后会自动更新插入对象的 主键id值
        int i = urlService.addUrl(newurl);
        System.out.println(i);
        System.out.println(newurl.toString());
        return ResponseData.creatResponseData(newurl);
    }

    /** 修改 路径配置数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/updateUrlById")
    @ResponseBody
    Map updateUrlById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String to = request.getParameter("to");
        String name = request.getParameter("name");
        int tagFatherId = Integer.valueOf(request.getParameter("tagFatherId"));
        int number = Integer.valueOf(request.getParameter("number"));
        int hidden = Integer.valueOf(request.getParameter("hidden"));
        Url newurl = new Url(id,to,name,tagFatherId,number,hidden);
        //i 为受影响行数 且在插入成功后会自动更新插入对象的 主键id值
        int i = urlService.updateUrlById(newurl);
        System.out.println(i);
        System.out.println(newurl.toString());
        return ResponseData.creatResponseData(newurl);
    }

}

