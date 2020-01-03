package com.flyonsky.datastructure.stack;

import org.junit.Test;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/3
 */
public class IntLinkedStackTest {

    @Test
    public void testIntLinkedStack1(){
        IntLinkedStack intLinkedStack = new IntLinkedStack();
        for(int i = 0;i< 15;i++){
            intLinkedStack.push(i);
        }
        while (!intLinkedStack.isEmpty()){
            System.out.println(intLinkedStack.pop());
        }
    }

    @Test
    public void testBinary(){
        IntLinkedStack intLinkedStack = new IntLinkedStack();
        int num = 10;
        while(num > 0){
            intLinkedStack.push(num % 2);
            num = num / 2;
        }

        while (!intLinkedStack.isEmpty()){
            System.out.print(intLinkedStack.pop());
        }
        System.out.println();
    }
}
