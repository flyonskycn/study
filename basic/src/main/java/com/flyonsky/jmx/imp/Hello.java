package com.flyonsky.jmx.imp;

import com.flyonsky.jmx.HelloMBean;

/**
 * @author luowengang
 * @date 2020/1/14 22:50
 */
public class Hello implements HelloMBean {
    @Override
    public void setHello() {
        System.out.println("jmx hello");
    }
}
