package com.react.entity;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/4/10 15:36
 */
public class Messages {
      private int messageId ; //  '主键ID',
      private int pushUserId; //  '发送消息用户id',
      private int pullUserId; //   '接收消息用户id',
      private String timestamp ; //      '消息时间戳',
      private String message   ; //  '消息内容',

    public Messages(int messageId, int pushUserId, int pullUserId, String timestamp, String message) {
        this.messageId = messageId;
        this.pushUserId = pushUserId;
        this.pullUserId = pullUserId;
        this.timestamp = timestamp;
        this.message = message;
    }

    public Messages() {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getPushUserId() {
        return pushUserId;
    }

    public void setPushUserId(int pushUserId) {
        this.pushUserId = pushUserId;
    }

    public int getPullUserId() {
        return pullUserId;
    }

    public void setPullUserId(int pullUserId) {
        this.pullUserId = pullUserId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "messageId=" + messageId +
                ", pushUserId=" + pushUserId +
                ", pullUserId=" + pullUserId +
                ", timestamp=" + timestamp +
                ", message=" + message +
                '}';
    }
}
