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

    public static Map creatResponseData(Object o){
        Map<String,Object> map = new HashMap();
        map.put("status",200);
        map.put("data",o);
        map.put("message","success");
        return map;
    }
}
