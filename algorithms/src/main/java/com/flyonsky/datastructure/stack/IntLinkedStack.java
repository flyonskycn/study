package com.flyonsky.datastructure.stack;

import com.flyonsky.datastructure.linkedlist.SinglyLinkedList;

/**
 * 栈的链表实现
 * @author luowengang
 * @date 2020/1/2 23:04
 */
public class IntLinkedStack {
    /**
     * 存储栈值的链表
     */
    private SinglyLinkedList singlyLinkedList;
    /**
     * 栈大小
     */
    private int size;

    /**
     * 构造函数
     */
    public IntLinkedStack(){
        singlyLinkedList = new SinglyLinkedList();
        size = 0;
    }

    /**
     * 入栈
     * @param data 值
     */
    public void push(int data){
        singlyLinkedList.insertHead(data);
        size++;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if(!isEmpty()){
            size--;
            return singlyLinkedList.deleteHead();
        }else {
            throw new RuntimeException("stack is empty");
        }
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }
}
