package com.flyonsky;

import org.junit.Test;

/**
 * @author luowengang
 * @date 2021/6/21 20:53
 */
public class NumberTest {

    @Test
    public void testDouble(){
        Double value = Double.parseDouble("12345678.6");
        System.out.println(value);
        value = Double.parseDouble("1234567.6");
        System.out.println(value);
    }
}
