package com.flyonsky.datastructure.array;

import org.junit.Test;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/13
 */
public class OrderlyIntArrayTest {

    @Test
    public void testAdd(){
        OrderlyIntArray orderlyIntArray = new OrderlyIntArray();
        for(int i = 32; i>0; i--){
            orderlyIntArray.add(i);
        }
        System.out.println(orderlyIntArray.toString());
    }
}
