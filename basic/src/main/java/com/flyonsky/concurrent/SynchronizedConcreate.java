package com.flyonsky.concurrent;

import java.text.MessageFormat;

/**
 * @author luowengang
 * @date 2020/9/6 19:39
 */
public class SynchronizedConcreate {
    public static void main(String[] args) throws InterruptedException{
        long s = System.currentTimeMillis();
        Thread[] ts = new Thread[100];
        for(int i=0;i<100;i++){
            ts[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        SynchronizedService service = new SynchronizedService();
                        service.add();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            ts[i].start();
        }
        for(Thread t : ts){
            t.join();
        }
        System.out.println(MessageFormat.format( "run cost {0} ms", System.currentTimeMillis() - s));
    }

    public static class SynchronizedService{

        private  int num;

        public synchronized void add() throws InterruptedException{
            Thread.sleep(10);
            num++;
        }

        public int getNum(){
            return num;
        }
    }
}
