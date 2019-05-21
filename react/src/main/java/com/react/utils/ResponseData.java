package com.react.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/10 16:36
 */
public class ResponseData {

    /**
     * 组装 响应参数的map 对象 成功
     * @param o
     * @return
     */
    public static Map creatResponseData(Object o){
        Map<String,Object> map = new HashMap();
        map.put("status",0);
        map.put("data",o);
        map.put("message","success");
        return map;
    }

    /**
     * 组装 响应 报错 参数的map对象
     * @param message
     * @return
     */
    public static Map creatResponseDataError(String message){
        Map<String,Object> map = new HashMap();
        map.put("status",20);
        map.put("message",message);
        return map;
    }
}
