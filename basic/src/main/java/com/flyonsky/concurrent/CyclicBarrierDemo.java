package com.flyonsky.concurrent;

import java.util.concurrent.*;

/**
 * 栅栏样例
 * @author luowengang
 * @date 2020/9/12
 */
public class CyclicBarrierDemo {
    private static final int BARRIER_COUNT = 3;

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(BARRIER_COUNT,()-> {
            System.out.println("main status check");
        });
        for(int i =0; i < BARRIER_COUNT; i ++){
            executorService.submit(()->{
                try{
                    System.out.println(Thread.currentThread().getName() + " first status concreate");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " second status concreate");
                    cyclicBarrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    System.out.println(Thread.currentThread().getName() + " thread interrupted ");
                }
            });
        }
        executorService.shutdown();

        while (!executorService.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("thread pool is running");
        }
        System.out.println("main thread exit" );
    }
}
