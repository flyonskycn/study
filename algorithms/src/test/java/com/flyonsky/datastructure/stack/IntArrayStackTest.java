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

    @Test
    public void testBinary(){
        IntArrayStack intArrayStack = new IntArrayStack();
        int num = 10;
        while(num > 0){
            intArrayStack.push(num % 2);
            num = num / 2;
        }

        while (!intArrayStack.isEmpty()){
            System.out.print(intArrayStack.pop());
        }
    }
}
