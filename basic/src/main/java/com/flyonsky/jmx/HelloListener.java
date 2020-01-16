package com.flyonsky.jmx;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/16
 */
public class HelloListener implements NotificationListener {

    @Override
    public void handleNotification(Notification notification, Object handback) {
        if(handback instanceof HelloMXBean){
            HelloMXBean helloMXBean = (HelloMXBean)handback;
            ((HelloMXBean) handback).printChange(notification.getMessage());
        }
    }
}
