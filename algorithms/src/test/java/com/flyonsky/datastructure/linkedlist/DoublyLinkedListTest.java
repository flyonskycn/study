package com.flyonsky.datastructure.linkedlist;

import org.junit.Test;

/**
 * 描述
 *
 * @author luowengang
 * @date 2020/1/2
 */
public class DoublyLinkedListTest {

    @Test
    public void testDoublyLinkedList(){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insert(1);
        linkedList.insert(5);
        linkedList.insert(7);

        // ->1->5->7
        System.out.println(linkedList.toString());

        linkedList.delete();

        // ->1->5
        System.out.println(linkedList.toString());

        linkedList.insert(10);

        // ->1->5->10
        System.out.println(linkedList.toString());
    }
}
