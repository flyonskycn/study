package com.flyonsky.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luowengang
 * @date 2020/9/9
 */
public class BlockBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[2];
    private int putptr, takeptr, count;

    /**
     * 添加记录
     * @param x
     * @throws InterruptedException
     */
    public void put(Object x ) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length ) {
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length ){
                putptr = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 弹出记录
     * @return
     * @throws InterruptedException
     */
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length ){
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x ;
        } finally {
            lock.unlock();
        }
    }
}