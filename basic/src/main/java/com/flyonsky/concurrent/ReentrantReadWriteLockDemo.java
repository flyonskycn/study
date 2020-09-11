package com.flyonsky.concurrent;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock样例
 * @author luowengang
 * @date 2020/9/11
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        final CacheQueue cacheQueue = new CacheQueue();
        executorService.submit(()->{
            while(true){
                Thread.sleep((long)(Math.random()*1000));
                cacheQueue.put(new Random().nextInt(10000));
                if(Thread.currentThread().isInterrupted()){
                    throw new InterruptedException();
                }
            }
        });
        for(int i=0; i<5; i++){
            executorService.submit(()->{
                while(true){
                    Thread.sleep((long)(Math.random()*100));
                    cacheQueue.get();
                    if(Thread.currentThread().isInterrupted()){
                        throw new InterruptedException();
                    }
                }
            });
        }
        Thread.sleep(1000L);
        executorService.shutdownNow();
        while(!executorService.awaitTermination(100L,TimeUnit.MILLISECONDS)){
            System.out.println("线程池还在运行");
        }
        System.out.println("主线程关闭");
    }

    public static class CacheQueue implements Serializable{
        //共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
        private volatile Object data = null;
        private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        public void get(){
            try {
                //上读锁，其他线程只能读不能写
                rwl.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " have read data :" + data);
            }finally {
                //释放读锁
                rwl.readLock().unlock();
            }
        }

        public void put(Object data){
            try {
                //上写锁，不允许其他线程读也不允许写
                rwl.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " be ready to write data!");
                this.data = data;
                System.out.println(Thread.currentThread().getName() + " have write data: " + data);
            }finally {
                //释放写锁
                rwl.writeLock().unlock();
            }
        }
    }
}
