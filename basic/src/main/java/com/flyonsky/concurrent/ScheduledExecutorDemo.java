package com.flyonsky.concurrent;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author luowengang
 * @date 2020/9/6 20:04
 */
public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        for(int i =0;i <10;i ++){
            threadPool.schedule(new ScheduledService(i), 1000, TimeUnit.MILLISECONDS);
        }
        threadPool.shutdown();
    }

    private static class ScheduledService implements Runnable{
        private int num ;

        ScheduledService( int i ){
            num = i;
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
