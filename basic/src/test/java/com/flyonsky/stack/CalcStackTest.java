package com.flyonsky.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * CalcStack 单元测试
 * @author luowengang
 * @date 2020/1/4 22:36
 */
public class CalcStackTest {

    @Test
    public void testValidExpression1(){
        String abc = "((a+b*6))";
        CalcStack calcStack = new CalcStack();
        boolean flag = calcStack.validExpression(abc);
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void testValidExpression2(){
        String abc = "((a+b*6)";
        CalcStack calcStack = new CalcStack();
        boolean flag = calcStack.validExpression(abc);
        System.out.println(flag);
        Assert.assertFalse(flag);
    }
}
