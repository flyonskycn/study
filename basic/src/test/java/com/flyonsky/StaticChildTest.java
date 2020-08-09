package com.flyonsky;

import org.junit.Test;

public class StaticChildTest {

    @Test
    public void testLoadOrder(){
        StaticChild.print();
    }

    @Test
    public void test1(){
        Long l1 = 1L;
        System.out.println(Long.toBinaryString(l1));

        Long l2 = -1L ^ (-1L << 5);
        System.out.println(Long.toBinaryString(l2));
        System.out.println(l2);
    }
}
