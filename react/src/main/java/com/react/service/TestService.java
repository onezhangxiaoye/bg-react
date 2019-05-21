package com.react.service;

import com.react.entity.Img;
import com.react.entity.Test;
import com.react.pojo.ImgMapper;
import com.react.pojo.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/6 22:37
 */
@Service
public class TestService implements TestMapper {


    @Autowired
    private TestMapper testMapper;


    @Override
    public int addTest(Test test) {
        return testMapper.addTest(test);
    }
}
