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
        head = new Link(0);
        tail = new Link(0);
        head.next = tail;
        tail.previous = head;
    }

    /**
     * 添加数据
     * @param data 数据值
     */
    public void insert(int data){
        Link link = new Link(data);
        tail.previous.next = link;
        link.previous = tail.previous;
        link.next = tail;
        tail.previous = link;
    }

    /**
     * 删除链表数据
     */
    public void delete(){
        tail.previous.previous.next = tail;
        tail.previous = tail.previous.previous;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link link = head.next;
        while(link != tail){
            sb.append("->").append(link.getValue());
            link = link.next;
        }

        return sb.toString();
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
