package com.flyonsky.guava;

import org.junit.Assert;
import org.junit.Test;

import static com.google.common.base.Preconditions.*;

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

    @Test
    public void testCheckElementIndex(){
        int index = checkElementIndex(2, 5, "abc");
        Assert.assertEquals(index, 2);
    }
}
