package com.react.pojo;

import com.react.entity.Img;
import com.react.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImgMapper {

    /**插入一个图片数据
     *
     * @param img 图片对象
     * @return 某一个对象
     */
    void addImg(Img img);

    /**
     * 查询所有的图片数据
     * @return 图片数组集合
     */
    List<Img> selectAllImg();
}