package com.flyonsky.jmx.imp;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/16
 */
public class SecondHello extends NotificationBroadcasterSupport implements SecondHelloMBean {
    private int seq;

    @Override
    public void sayHi() {
        System.out.println("hello jmx the second");
    }

    @Override
    public void changePool(int poolNum) {
        seq++;
        Notification notification = new Notification("changePool", this, seq, System.currentTimeMillis(), String.valueOf(poolNum));
        this.sendNotification(notification);
    }
}
