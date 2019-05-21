package com.react.utils;

import java.util.UUID;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/15 17:56
 */
public class UUIDUtil {
    /**
     *
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
