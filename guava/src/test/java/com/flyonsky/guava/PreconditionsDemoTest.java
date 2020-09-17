package com.flyonsky.guava;

import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/17 21:44
 */
public class PreconditionsDemoTest {

    @Test(expected = NullPointerException.class)
    public void testSum(){
        PreconditionsDemo preconditionsDemo = new PreconditionsDemo();
        Integer sum = preconditionsDemo.sum(null, 10);
    }
}
