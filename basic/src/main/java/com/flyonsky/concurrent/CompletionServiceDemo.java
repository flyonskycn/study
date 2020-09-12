package com.flyonsky.concurrent;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.*;

/**
 * CompletionService 样例
 * @author luowengang
 * @date 2020/9/12
 */
public class CompletionServiceDemo {

    public static void main(String[] args) throws InterruptedException,ExecutionException {
        final int threadCount = 5;
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        CompletionService<String> comService = new ExecutorCompletionService<String>(executorService);

        for(int i =0;i <threadCount; i++){
            comService.submit(() -> {
                int rd = Math.abs( new Random().nextInt());
                String result = MessageFormat.format("the thread: {0} result {1} ",Thread.currentThread().getName(), rd);
                return result ;
            });
        }
        for(int i =0;i <threadCount; i++){
            System.out.println(comService.take().get());
        }
        executorService.shutdown();

        while (!executorService.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("thread pool is running");
        }
        System.out.println("main thread exit" );
    }
}
