package com.react.pojo;

import com.react.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**根据 ID 查询用户数据
     *
     * @param id 用户id
     * @return 某一个对象
     */
    User selectByPrimaryKey(Integer id);

    /**查询所有用户数据
     *
     * @return 结果集合
     */
    List<User> selectAllData();

    /**根据 用户名 查询用户数据
     *
     * @param name 用户名
     * @return 某一个对象
     */
    User selectByUserName(String name);

    /**注册用户信息
     *
     * @param user 用户对象
     */
    int register(User user);
}