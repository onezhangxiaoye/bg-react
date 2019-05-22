package com.react.controller;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.react.entity.Messages;
import com.react.entity.User;
import com.react.service.MessagesService;
import com.react.utils.TimerTaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/4/10 13:25
 */
@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {

    @Autowired
    public MessagesService messagesService = ApplicationContextProvider.getBean(MessagesService.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";

    //定时任务
    Timer timer = new Timer();
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("新用户进入开始监听:--用户id="+sid+",当前在线人数为" + getOnlineCount());
        this.sid=sid;
        try {
            Gson gson = new Gson();
            Map<String,Object> map = new HashMap<>();
            map.put("type","message");
            sendMessage(gson.toJson(map));
//            TimerTask timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    try {
//                        sendMessage("服务器推送信息：" + new Date().getTime());
//                    } catch (IOException e) {
//
//                        e.printStackTrace();
//                    }
//                }
//            };
//            //定时任务
//            new Timer().schedule(timerTask, 3000 ,3000);
        } catch (IOException e) {
            System.out.println("websocket IO异常");
        }catch (Exception e){
            System.out.println("定时器异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到来自窗口"+sid+"的信息:"+message);
        Messages messages = null;
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        map.put("type","push");
        try {
            messages = gson.fromJson(message, Messages.class);
            messages.setPushUserId(Integer.valueOf(sid));
            System.out.println(messages);
            messagesService.addMessage(messages);
        }catch (NullPointerException e){
            System.out.println("空指针异常");
            e.printStackTrace();
        }

        //群发消息
        for (WebSocketServer item : webSocketSet) {
            System.out.println(item.toString());
            try {
                if (item.sid.equals(String.valueOf(messages.getPullUserId()))){
                    map.put("data",messages);
                    item.sendMessage(gson.toJson(map));
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
        System.out.println("推送消息到窗口"+sid+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(sid==null) {
                    item.sendMessage(message);
                }else if(item.sid.equals(sid)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}


