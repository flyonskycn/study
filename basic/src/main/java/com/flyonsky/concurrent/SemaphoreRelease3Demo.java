package com.flyonsky.concurrent;

import java.util.concurrent.*;

/**
 * 信号量finally中释放
 * @author luowengang
 * @date 2021/01/29
 */
public class SemaphoreRelease3Demo {
    private static final int THREAD_COUNT = 30;
    private static final int SEMAPHORE_COUT = -1;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        final Semaphore sep = new Semaphore(SEMAPHORE_COUT);
        for(int i =0; i < THREAD_COUNT; i ++){
            executorService.submit(()->{
                boolean isAcquire = false;
                try{
                    sep.acquire();
                    isAcquire = true;
                    System.out.println(Thread.currentThread().getName() + " access pools");
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName() + " thread interrupted ");
                }finally {
                    if(isAcquire){
                        sep.release();
                    }
                }
            });
        }
        executorService.shutdownNow();

        while (!executorService.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("thread pool is running");
        }

        System.out.println("Semaphore init is "+ SEMAPHORE_COUT +" , release Semaphore is " + sep.drainPermits());
        System.out.println("main thread exit" );
    }
}
