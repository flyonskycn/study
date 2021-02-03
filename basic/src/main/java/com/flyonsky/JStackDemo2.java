package com.flyonsky;

/**
 * @author luowengang
 * @date 2021/1/9 21:30
 */
public class JStackDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Thread1());
        thread.start();
    }
}
class Thread1 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println(1);
        }
    }
}
