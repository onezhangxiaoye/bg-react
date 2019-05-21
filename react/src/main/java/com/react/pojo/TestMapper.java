package com.react.pojo;

import com.react.entity.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    /**插入一个测试数据
     *
     * @param test 图片对象
     * @return 某一个对象
     */
    int addTest(Test test);

}