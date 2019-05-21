package com.react.pojo;

import com.react.entity.Messages;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessagesMapper {

    /**插入一条消息
     *
     * @param messages 消息对象
     * @return
     */
    void addMessage(Messages messages);

    /**
     * 查询所有的图片数据
     * @return 图片数组集合
     */
    List<Messages> selectAlladdMessageByIds(int pushUserId,int pullUserId);
}