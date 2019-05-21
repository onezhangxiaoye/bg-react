package com.react.controller;

import com.react.entity.Img;
import com.react.service.FileService;
import com.react.utils.FileUpload;
import com.react.utils.ResponseData;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/15 14:48
 */
@Controller
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/FileController")
public class FileController {

    @Autowired
    private FileService fileService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    /** 添加图片数据 并且 保存上传的图片
     *
     * @param
     * @return
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    Map fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        String imgName = request.getParameter("imgName");
        String introduce = request.getParameter("introduce");
        String comment = request.getParameter("comment");


        String imgPath = FileUpload.fileUpload(file);
        if (!imgPath.equals("error")){
            System.out.println(imgName + "----" + introduce + "" + comment + "---" + imgPath);
            fileService.addImg(imgName,introduce,imgPath,comment);
            return ResponseData.creatResponseData(new Img());
        }
        return ResponseData.creatResponseDataError("图片上传失败");
    }

    /** 单图片上传
     *
     * @param
     * @return
     */
    @RequestMapping("/onefileUpload")
    @ResponseBody
    Map onefileUpload(@RequestParam("file") MultipartFile file) {

        String imgPath = FileUpload.fileUpload(file);
        if (!imgPath.equals("error")){
            return ResponseData.creatResponseData("图片上传成功！" + imgPath);
        }
        return ResponseData.creatResponseDataError("图片上传失败！");
    }
}
