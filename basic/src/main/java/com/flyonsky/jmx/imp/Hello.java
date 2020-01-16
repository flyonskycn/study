package com.flyonsky.jmx.imp;

import com.flyonsky.jmx.HelloMXBean;

/**
 * @author luowengang
 * @date 2020/1/14 22:50
 */
public class Hello implements HelloMXBean {
    @Override
    public void sayHi() {
        System.out.println("jmx hello the first");
    }

    @Override
    public void printChange(String changeMsg) {
        System.out.println("data change " + changeMsg);
    }
}
