package com.flyonsky.datastructure.linkedlist;

import lombok.*;

/**
 * 双向链表
 *
 * @author luowengang
 * @date 2019/11/15
 */
public class DoublyLinkedList {

    /** 头 **/
    private Link head;
    /** 尾 **/
    private Link tail;

    public DoublyLinkedList(){

    }



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Link{
        /** 前置结点 **/
        private Link previous;

        /** 后置结点 **/
        private Link next;
        /** 值 **/
        private int value;
    }
}
