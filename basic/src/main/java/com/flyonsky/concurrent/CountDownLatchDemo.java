package com.flyonskyspring.factories.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CountDownLatch样例
 * @author luowengang
 * @date 2020/9/11
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        final int threadCount = 5;
        final CountDownLatch start = new CountDownLatch(threadCount);

        for(int i =0;i <threadCount; i++){
            executorService.submit(() -> {
                try{
                    Thread.sleep(Math.abs (new Random().nextInt(20)));
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " run success");
                start.countDown();
            });
        }
        start.await();
        System.out.println("main thread run success" );

        executorService.shutdown();

        while (!executorService.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("thread pool is running");
        }
        System.out.println("main thread exit" );
    }
}
