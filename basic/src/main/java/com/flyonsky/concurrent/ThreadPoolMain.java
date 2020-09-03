package com.flyonsky.concurrent;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author luowengang
 * @date 2020/9/3 23:48
 */
public class ThreadPoolMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService threadService = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<Future<String>>();
        for(int i =0;i <2;i ++){
            list.add( threadService.submit(new UserCallable(i)));
        }
        int num = 0;
        for(Future<String> f : list ){
            System. out.println(MessageFormat.format( "main{0} result{1} ", num, f.get()));
            num++;
        }
        threadService.shutdown();
    }

    private static class UserCallable implements Callable<String> {
        private int num ;

        public UserCallable(int i){
            this.num = i ;
        }
        @Override
        public String call() throws Exception {
            int rd = Math.abs( new Random().nextInt());
            String result = MessageFormat. format("the thread{0} result {1} ",this. num, rd);
            System. out.println(result );
            return String.valueOf (rd );
        }

    }
}
