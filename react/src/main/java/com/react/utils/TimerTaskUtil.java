package com.react.utils;

import java.util.TimerTask;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/4/10 15:20
 */
public class TimerTaskUtil extends TimerTask {
    private int id;
    private static int count = 0;

    public TimerTaskUtil() {}

    public TimerTaskUtil(int id) {
        id = this.id;
    }

    @Override
    public void run() {
        System.out.println(count);
        count++;
        if(count > 5){
            this.cancel();
        }
    }
}
