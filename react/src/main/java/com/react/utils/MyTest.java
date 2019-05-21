package com.react.utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/3/19 14:23
 */
public class MyTest {

    public static void main(String[] args)  {
        int id = 30;
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask(id);
        timer.schedule(myTimerTask,1000,1000);
    }

}

class MyTimerTask extends TimerTask{
    private int id;
    private static int count = 0;

    public MyTimerTask(int id) {
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
