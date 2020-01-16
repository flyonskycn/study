package com.flyonsky.jmx.imp;

/**
 * 第二种定义jmx bean的方式
 *
 * @author luowengang
 * @date 2020/1/16
 */
public interface SecondHelloMBean {

    /**
     * JMX方法
     */
    void sayHi();

    /**
     * 修改池大小
     * @param poolNum 池大小
     */
    void changePool(int poolNum);
}
