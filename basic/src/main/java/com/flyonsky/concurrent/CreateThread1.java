package com.flyonsky.concurrent;

import java.text.MessageFormat;

/**
 * @author luowengang
 * @date 2020/8/31 22:44
 */
public class CreateThread1 {

    public static void main(String[] args){
        for(int i =0;i <10;i ++){
            new UserThread(i).start();
        }
        System. out.println("main thread is run success.");
    }

    private static class UserThread extends Thread{
        private int num ;

        public UserThread(int i){
            this.num = i ;
        }

        @Override
        public void run() {
            try {
                sleep(10L);
            } catch (InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System. out.println(MessageFormat.format( "the {0} thread is run success.", this. num));
        }

    }
}
