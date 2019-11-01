package com.flyonsky;

import org.junit.Assert;
import org.junit.Test;

/**
 * 装箱拆箱测试
 *
 * @author luowengang
 * @date 2019/10/28
 */
public class BoxTest {

    @Test
    public void testInteger(){
        // 两个new出来的Integer类型的数据比较，相当于把new出来的地址作比较
        Integer a0 = new Integer(1);
        Integer a1 = new Integer(1);
        System.out.println("Integer 对象作比较 a0 == a1: " + (a0 == a1));
        Assert.assertFalse(a0 == a1);

        // 调用intValue方法得到其int值
        System.out.println("使用intValue得到int值作比较 a0 == a1: " + (a0.intValue() == a1.intValue()));
        Assert.assertTrue(a0.intValue() == a1.intValue());

        // 把Integer类型的变量拆箱成int类型
        int a2 = 1;
        System.out.println("将Integer自动拆箱 a1 == a2: " + (a1 == a2));
        Assert.assertTrue(a1 == a2);
        Assert.assertTrue(a2 == a1);

        // Integer对象赋值比较，其实也是内存地址的比较
        // 自动装箱，如果在-128到127之间，则值存在常量池中
        Integer a3 = 30;
        Integer a4 = 30;
        System.out.println("Integer对象赋值比较 a3 == a4: " + (a3 == a4));
        Assert.assertTrue(a3 == a4);

        // Integer对象赋值(超过-128~127区间)比较
        Integer a5 = 128;
        Integer a6 = 128;
        System.out.println("Integer对象赋值(超过-128~127区间)比较 a5 == a6: " + (a5 == a6));
        Assert.assertFalse(a5 == a6);

        // Integer对象赋值(超过-128~127区间)比较,调用intValue后再作比较
        Integer a7 = 128;
        Integer a8 = 128;
        System.out.println("Integer对象赋值(超过-128~127区间)比较,调用intValue后 a7 == a8: " + (a7.intValue() == a8.intValue()));
        Assert.assertTrue(a7.intValue() == a8.intValue());

        // 使用Integer类的equals()方法进行的是数值的比较
        Integer a9 = 129;
        Integer a10 = 129;
        System.out.println("Integer类的equals()方法进行的是数值的比较 a9 == a10: " + a9.equals(a10));
        Assert.assertTrue(a9.equals(a10));
    }

    @Test
    public void testLong(){
        Long a0 = new Long(1);
        Long a1 = new Long(1);
        System.out.println("Long 对象作比较 a0 == a1: " + (a0 == a1));
        Assert.assertFalse(a0 == a1);

        System.out.println("使用longValue得到int值作比较 a0 == a1: " + (a0.longValue() == a1.longValue()));
        Assert.assertTrue(a0.longValue() == a1.longValue());

        long a2 = 1;
        System.out.println("将Long自动拆箱 a1 == a2: " + (a1 == a2));
        Assert.assertTrue(a1 == a2);
        Assert.assertTrue(a2 == a1);

        // Long对象赋值比较，其实也是内存地址的比较
        // 自动装箱，如果在-128到127之间，则值存在常量池中
        Long a3 = 30L;
        Long a4 = 30L;
        System.out.println("Long对象赋值比较 a3 == a4: " + (a3 == a4));
        Assert.assertTrue(a3 == a4);

        // Long对象赋值(超过-128~127区间)比较
        Long a5 = 128L;
        Long a6 = 128L;
        System.out.println("Long对象赋值(超过-128~127区间)比较 a5 == a6: " + (a5 == a6));
        Assert.assertFalse(a5 == a6);

        // Long对象赋值(超过-128~127区间)比较,调用intValue后再作比较
        Long a7 = 128L;
        Long a8 = 128L;
        System.out.println("Long对象赋值(超过-128~127区间)比较,调用intValue后 a7 == a8: " + (a7.intValue() == a8.intValue()));
        Assert.assertTrue(a7.intValue() == a8.intValue());

        // 使用Long类的equals()方法进行的是数值的比较
        Long a9 = 129L;
        Long a10 = 129L;
        System.out.println("Long类的equals()方法进行的是数值的比较 a9 == a10: " + a9.equals(a10));
        Assert.assertTrue(a9.equals(a10));
    }
}
