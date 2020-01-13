package com.flyonsky.datastructure.array;

import org.junit.Test;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/13
 */
public class ReallocateArrayTest {

    @Test
    public void testAdd(){
        ReallocateArray reallocateArray = new ReallocateArray<Integer>();

        for(int i = 0;i<100;i++) {
            reallocateArray.add(i);
        }

        System.out.println(reallocateArray);
    }
}
