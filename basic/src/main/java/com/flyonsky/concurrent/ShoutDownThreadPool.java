package com.flyonsky.concurrent;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author luowengang
 * @date 2020/9/10
 */
public class ShoutDownThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadService = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<Future<String>>();
        for(int i =0;i <10;i ++){
            list.add(threadService.submit(new WaitCallable(i)));
        }
        threadService.shutdown();
        while(!threadService.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("线程池还在运行中");
        }
        System.out.println("程序优雅关闭");
    }

    private static class WaitCallable implements Callable<String> {
        private int num ;

        public WaitCallable(int i){
            this.num = i ;
        }
        @Override
        public String call() throws Exception {
            int rd = Math.abs(new Random().nextInt());
            // 暂停10秒
            Thread.sleep(10000);
            String result = MessageFormat.format("the thread{0} result {1} ",this. num, rd);
            System.out.println(result );
            return String.valueOf (rd );
        }
    }
}
