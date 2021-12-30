package com.flyonsky;

import java.util.concurrent.CountDownLatch;

/**
 * 测试Thread 的 sleep方法，会不会释放CPU, 从运行结果看出： Thread 的 sleep方法会释放 CPU
 * @author luowengang
 * @date 2021/12/30
 */
public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(8);
        long begin = System.currentTimeMillis();
        for(int i=0; i<4; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(30 * 1000);
                        countDownLatch.countDown();
                    }catch (InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }
                }
            });
            thread.start();
        }

        for(int i=0; i<4; i++){
            final int threadNumber =i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        System.out.println("thead " + threadNumber + " messsage :" + i);
                    }
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        countDownLatch.await();
        System.out.println("execute cost " + (System.currentTimeMillis() - begin) + "ms");
    }
}
