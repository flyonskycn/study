package com.flyonsky.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/2
 */
public class DoublyLinkedListTest {

    @Test
    public void testDoublyLinkedList1(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertTail(1);
        linkedList.insertTail(5);
        linkedList.insertTail(7);

        // 1->5->7
        System.out.println(linkedList.toString());
        Assert.assertEquals("1->5->7", linkedList.toString());

        linkedList.deleteTail();

        // ->1->5
        System.out.println(linkedList.toString());
        Assert.assertEquals("1->5", linkedList.toString());

        linkedList.insertTail(10);

        // ->1->5->10
        System.out.println(linkedList.toString());
        Assert.assertEquals("1->5->10", linkedList.toString());
    }

    @Test
    public void testDoublyLinkedList2(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertHead(5);
        doublyLinkedList.insertHead(9);
        doublyLinkedList.insertHead(20);
        // 20->9->5
        System.out.println(doublyLinkedList.toString());
        Assert.assertEquals("20->9->5", doublyLinkedList.toString());

        doublyLinkedList.deleteHead();

        // 9->5
        System.out.println(doublyLinkedList.toString());
        Assert.assertEquals("9->5", doublyLinkedList.toString());

        doublyLinkedList.insertHead(2);
        // 2->9->5
        System.out.println(doublyLinkedList.toString());
        Assert.assertEquals("2->9->5", doublyLinkedList.toString());
    }
}
