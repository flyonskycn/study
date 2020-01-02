package com.flyonsky.datastructure.linkedlist;

import lombok.*;

/**
 * 单一链表
 * 用一个节点做哨兵节点
 *
 * @author luowengang
 * @date 2019/10/28
 */
public class SinglyLinkedList {
    /**
     * 链表头，作为哨兵
     */
    private Node head;
    /**
     * 链表中的节点数
     */
    private int size;

    /**
     * 链表构造函数
     */
    public SinglyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    /**
     * 头部插入元素
     *
     * @param x 元素值
     */
    public void insertHead(int x) {
        insertNth(x, 0);
    }

    /**
     * 在链表末尾插入元素
     *
     * @param data 元素值
     */
    public void insert(int data) {
        insertNth(data, size);
    }

    /**
     * 在指定位置插入节点
     *
     * @param data     元素值
     * @param position 新元素插入的位置
     */
    public void insertNth(int data, int position) {
        checkBounds(position, 0, size);
        Node cur = head;
        // 找到position前一个节点
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    /**
     * 删除头部节点
     *
     */
    public void deleteHead() {
        deleteNth(0);
    }

    /**
     * 删除尾部的元素
     */
    public void delete() {
        deleteNth(size - 1);
    }

    /**
     * 删除第n个位置的元素
     */
    public void deleteNth(int position) {
        checkBounds(position, 0, size - 1);
        Node cur = head;
        // 找到position前一个节点
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }

        // 删除节点
        cur.next = cur.next.next;

        size--;
    }

    /**
     * 校验链表参数的范围是否合法
     * @param position 检查位置
     * @param low 链表的最小位
     * @param high 链表的最大位
     * @throws IndexOutOfBoundsException if {@code position} not in range {@code low} to {@code high}
     */
    void checkBounds(int position, int low, int high) {
        if (position < low || position > high) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /**
     * 清空链表
     */
    public void clear() {
        if (size == 0) {
            return;
        }
        // 清空哨兵节点的下一节点，整个节点即清空
        head.next = null;
        size = 0;
    }

    /**
     * 检查链表是否为空
     *
     * @return true:空链表
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表的元数个数
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = head.next;
        while (cur != null) {
            builder.append(cur.value).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();
    }

    @Data
    @Getter
    @Setter
    private static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
}