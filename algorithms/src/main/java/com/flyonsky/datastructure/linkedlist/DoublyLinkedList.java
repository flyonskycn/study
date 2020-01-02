package com.flyonsky.datastructure.linkedlist;

import lombok.*;

/**
 * 双向链表
 *
 * @author luowengang
 * @date 2019/11/15
 */
@Getter
@Setter
public class DoublyLinkedList {

    /** 头 **/
    private Link head;
    /** 尾 **/
    private Link tail;

    public DoublyLinkedList(){

    }

    public void insert(int data){

    }

    public void delete(){

    }

    @Getter
    @Setter
    public static class Link{
        /** 前置结点 **/
        private Link previous;

        /** 后置结点 **/
        private Link next;
        /** 值 **/
        private int value;

        public Link(int value){
            this.value = value;
        }
    }
}
