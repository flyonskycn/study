package com.flyonsky.concurrent;

import java.text.MessageFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author luowengang
 * @date 2020/9/6 20:01
 */
public class TimerSchedule {
    public static void main(String[] args) {
        Timer t = new Timer();

        for(int i =0;i <10;i ++){
            t.schedule( new TimerService(i ), 1000);
        }
    }

    private static class TimerService extends TimerTask {
        private int num ;

        public TimerService(int i){
            this.num = i ;
        }

        @Override
        public void run() {
            int l = new Random().nextInt();
            System. out.println(MessageFormat.format( "thread{0} is success", this. num));
            if(l % 2 == 0){
                System. out.println(MessageFormat.format( "thread{0} is Error", this. num));
                throw new NullPointerException();
            }
        }
    }
}
