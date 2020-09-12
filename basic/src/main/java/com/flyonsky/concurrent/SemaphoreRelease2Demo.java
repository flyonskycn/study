package com.flyonsky.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 信号量结尾处释放
 * @author luowengang
 * @date 2020/9/12
 */
public class SemaphoreRelease2Demo {
    private static final int THREAD_COUNT = 30;
    private static final int SEMAPHORE_COUT = 2;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        final Semaphore sep = new Semaphore(SEMAPHORE_COUT);
        for(int i =0; i < THREAD_COUNT; i ++){
            executorService.submit(()->{
                try{
                    sep.acquire();
                    int value = (new Random()).nextInt();
                    System.out.println(Thread.currentThread().getName() + " access pools value is :" + value);
                    if(value%2 == 0){
                        throw new RuntimeException();
                    }
                    sep.release();
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName() + " thread interrupted ");
                }
            });
        }
        executorService.shutdown();

        while (!executorService.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("thread pool is running");
        }

        System.out.println("Semaphore init is "+ SEMAPHORE_COUT +" , release Semaphore is " + sep.drainPermits());
        System.out.println("main thread exit" );
    }
}
