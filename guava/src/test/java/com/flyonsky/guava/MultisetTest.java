package com.flyonsky.guava;

import com.google.common.collect.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/23 21:47
 */
public class MultisetTest {

    @Test
    public void testMultiset(){
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");

        System.out.println(multiset.toString());
        System.out.println(multiset.count("a"));
        Assert.assertEquals(2,multiset.count("a"));
        System.out.println(multiset.size());
        Assert.assertEquals(3,multiset.size());
    }

    @Test
    public void testSortedMultiset(){
        SortedMultiset<String> sortedMultiset = TreeMultiset.create();
        sortedMultiset.add("a",1);
        sortedMultiset.add("b",2);
        sortedMultiset.add("c",3);
        sortedMultiset.add("d",4);
        sortedMultiset.add("e",5);
        sortedMultiset.add("f",6);
        sortedMultiset.add("g",7);
        sortedMultiset.add("h",8);

        System.out.println(sortedMultiset.subMultiset("a", BoundType.OPEN,"f",BoundType.CLOSED));
    }
}
