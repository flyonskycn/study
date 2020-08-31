package com.flyonsky.concurrent;

/**
 * @author luowengang
 * @date 2020/8/31 23:12
 */
public class CreateThread2 {

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for(int i =0;i <10;i ++){
            ts[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System. out.println("Sub Thread run success.");
                }
            });
            ts[i].start();
        }
        System. out.println("main thread is run success.");
    }
}
