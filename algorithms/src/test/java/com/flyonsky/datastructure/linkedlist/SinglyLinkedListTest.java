package com.flyonsky.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * 描述
 *
 * @author luowengang
 * @date 2019/10/28
 */
public class SinglyLinkedListTest {

    @Test
    public void testSinglyLinkedList(){
        SinglyLinkedList myList = new SinglyLinkedList();

        Assert.assertTrue(myList.isEmpty());

        myList.insertHead(5);
        myList.insertHead(7);
        myList.insertHead(10);

        System.out.println(myList); // 10 -> 7 -> 5

        myList.deleteHead();

        System.out.println(myList); // 7 -> 5

        myList.insertNth(11, 2);

        System.out.println(myList); // 7 -> 5 -> 11

        myList.deleteNth(1);

        System.out.println(myList); // 7-> 11

        myList.clear();
        Assert.assertTrue(myList.isEmpty());

        System.out.println(myList); // ""
    }
}
