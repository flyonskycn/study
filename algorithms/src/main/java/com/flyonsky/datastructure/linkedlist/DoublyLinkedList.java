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
        head = new Link(0);
        tail = new Link(0);
        head.next = tail;
        tail.previous = head;
    }

    public void insertHead(int data){
        Link link = new Link(data);
        link.next = head.next;
        link.previous = head;
        head.next.previous = link;
        head.next = link;
    }

    /**
     * 添加数据
     * @param data 数据值
     */
    public void insertTail(int data){
        Link link = new Link(data);
        link.previous = tail.previous;
        link.next = tail;
        tail.previous.next = link;
        tail.previous = link;
    }

    /**
     * 从尾部删除链表数据
     */
    public void deleteTail(){
        tail.previous.previous.next = tail;
        tail.previous = tail.previous.previous;
    }

    /**
     * 从头部删除链表数据
     */
    public void deleteHead(){
        head.next.next.previous = head;
        head.next = head.next.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link link = head.next;
        boolean first = true;
        while(link != tail){
            if(first){
                sb.append(link.getValue());
                first = false;
            }else{
                sb.append("->").append(link.getValue());
            }
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
