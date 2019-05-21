package com.react.pojo;

import com.react.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendsMapper {

    /**查询当前用户的所有好友信息
     *
     * @param id 当前用户的id
     * @return 某一个对象
     */
    List<User> selectAllFriends(int id);

    /**添加一个好友
     * @param id 好友ID
     * @return 图片数组集合
     */
    int addFriend(int id);
}