package com.react.service;

import com.react.entity.Url;
import com.react.entity.User;
import com.react.pojo.UrlMapper;
import com.react.pojo.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/1/15 11:17
 */
@Service
public class UrlService implements UrlMapper {

    @Resource
    private UrlMapper urlMapper;


    @Override
    public List<Url> selectAllData() {
        return urlMapper.selectAllData();
    }

    @Override
    public int addUrl(Url url) {
        return urlMapper.addUrl(url);
    }

    @Override
    public int updateUrlById(Url url) {
        return urlMapper.updateUrlById(url);
    }
}
