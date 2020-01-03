package com.flyonsky.datastructure.stack;

import org.junit.Test;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/3
 */
public class IntArrayStackTest {

    @Test
    public void testIntArrayStack1(){
        IntArrayStack intArrayStack = new IntArrayStack();
        for(int i = 0;i< 15;i++){
            intArrayStack.push(i);
        }
        while (!intArrayStack.isEmpty()){
            System.out.println(intArrayStack.pop());
        }
    }
}
