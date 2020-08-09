package com.flyonsky.sentinel;

import org.junit.Test;

/**
 * 滑动时间窗限流测试类
 * @author luowengang
 * @date 2020/8/9 12:01
 */
public class WindowLimiterTest {

    @Test
    public void testSlideWindow(){
        WindowLimiter windowLimiter = new WindowLimiter();
        windowLimiter.slideWindow();

        windowLimiter.shutDown();
    }
}
