package com.flyonsky.jmx;

import com.flyonsky.jmx.HelloMBean;

/**
 * @author luowengang
 * @date 2020/1/14 22:50
 */
public class Hello implements HelloMBean {
    @Override
    public void setWord() {
        System.out.println("jmx hello");
    }
}
