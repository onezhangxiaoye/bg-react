package com.react.service;

import com.react.entity.Messages;
import com.react.pojo.MessagesMapper;
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
public class MessagesService implements MessagesMapper {


    @Autowired
    private MessagesMapper messagesMapper;

    @Override
    public void addMessage(Messages messages) {
        System.out.println("发送消息---");
        messagesMapper.addMessage(messages);
    }

    @Override
    public List<Messages> selectAlladdMessageByIds(int pushUserId,int pullUserId) {
        return messagesMapper.selectAlladdMessageByIds(pushUserId, pullUserId);
    }
}
