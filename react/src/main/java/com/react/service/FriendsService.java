package com.react.service;

import com.react.entity.Url;
import com.react.entity.User;
import com.react.pojo.FriendsMapper;
import com.react.pojo.UrlMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/4/19 22:59
 */
@Service
public class FriendsService implements FriendsMapper {

    @Resource
    private FriendsMapper friendsMapper;


    @Override
    public List<User> selectAllFriends(int id) {
        return friendsMapper.selectAllFriends(id);
    }

    @Override
    public int addFriend(int id) {
        return friendsMapper.addFriend(id);
    }
}
