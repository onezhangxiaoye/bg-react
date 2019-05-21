package com.react.service;

import com.react.entity.Img;
import com.react.pojo.ImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/15 14:48
 */
@Service
public class FileService {

    @Autowired
    private ImgMapper imgMapper;

    public void addImg(String imgName,String introduce,String imgPath,String comment) {
        Img img = new Img();
        img.setImgName(imgName);
        img.setIntroduce(introduce);
        img.setImgPath(imgPath);
        img.setComment(comment);
        imgMapper.addImg(img);
    }

}
