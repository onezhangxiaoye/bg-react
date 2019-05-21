package com.react.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/4/10 13:48
 */
public class ApiReturnUtil implements Serializable{

    private static final long serialVersionUID = 1L;

    public static ApiReturnObject error(Object errorMessage) {
        System.out.println(errorMessage);
        List<Object> object=new ArrayList<Object>();
        return new ApiReturnObject("01",errorMessage,object);
    }
    public static ApiReturnObject error(Object errorMessage, Object returnObject) {
        List<Object> object=new ArrayList<Object>();
        object.add(returnObject);
        return new ApiReturnObject("01",errorMessage,object);
    }
    public static ApiReturnObject success(Object returnObject) {
        if(returnObject instanceof java.util.List){
            return new ApiReturnObject("00","success",returnObject);
        }else {
            List<Object> object=new ArrayList<Object>();
            object.add(returnObject);
            return new ApiReturnObject("00","success",object);
        }
    }
    public static ApiReturnObject success(Object errorMessage, Object returnObject) {
        if(returnObject instanceof java.util.List){
            return new ApiReturnObject("00",errorMessage,returnObject);
        }else {
            List<Object> object=new ArrayList<Object>();
            object.add(returnObject);
            return new ApiReturnObject("00",errorMessage,object);
        }
    }

}
