package com.react.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/15 19:41
 */
public class FileUpload {

    public static String fileUpload(MultipartFile file){
        if (file.isEmpty()) {
            return "error";
        }

        String fileName = file.getOriginalFilename();
//        String filePath = "/home/images/";
//        String filePath = "C:/Users/13002/Desktop/test/";

        String postfix = fileName.substring(fileName.lastIndexOf("."),fileName.length());

        //组装新的 文件名称
        String fileName2 = UUIDUtil.getUUID() + postfix;
        System.out.println(fileName2);

        File dest = new File(StaticDataName.IMGPATH + fileName2);
        try {
            file.transferTo(dest);
            System.out.println("上传成功");
            //成功返回文件名称
            return StaticDataName.IMGPATH + fileName2;
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return "error";
    }
}
