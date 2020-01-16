package com.flyonsky.jmx;

/**
 * @author luowengang
 * @date 2020/1/14 22:49
 */
public interface HelloMXBean {
    /**
     * jmx first
     */
    void sayHi();

    /**
     * 打印消息变化
     * @param changeMsg
     */
    void printChange(String changeMsg);
}
