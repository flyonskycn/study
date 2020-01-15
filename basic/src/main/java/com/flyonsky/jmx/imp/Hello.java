package com.flyonsky.jmx.imp;

import com.flyonsky.jmx.HelloMXBean;

/**
 * @author luowengang
 * @date 2020/1/14 22:50
 */
public class Hello implements HelloMXBean {
    @Override
    public void setWord() {
        System.out.println("jmx hello");
    }
}
