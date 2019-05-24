package com.react.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/5/22 10:44
 */
public class TimeUtil {
    //根据时间表达式生成DateTimeFormatter对象
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**转换字符串格式的时间
     *
     * @param time 标准时间字符串
     * @return
     */
    public static LocalDateTime parseDateTime(String time){
//        formatter.parse(time);
        // 执行解析
        return LocalDateTime.parse(time, formatter);
    }

}
