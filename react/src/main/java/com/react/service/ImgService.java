package com.react.service;

import com.react.entity.Img;
import com.react.pojo.ImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/6 22:37
 */
@Service
public class ImgService implements ImgMapper {


    @Autowired
    private ImgMapper imgMapper;

    @Override
    public void addImg(Img img) {
         imgMapper.addImg(img);
    }

    @Override
    public List<Img> selectAllImg() {
        return imgMapper.selectAllImg();
    }
}
