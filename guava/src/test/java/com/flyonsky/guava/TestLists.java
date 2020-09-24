package com.flyonsky.guava;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

/**
 * @author luowengang
 * @date 2020/9/24 23:01
 */
public class TestLists {

    @Test
    public void testLists(){
        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        System.out.println(countUp);
        // {5, 4, 3, 2, 1}
        List<Integer> countDown = Lists.reverse(countUp);
        System.out.println(countDown);

        // {{1, 2}, {3, 4}, {5}}
        List<List<Integer>> parts = Lists.partition(countUp, 2);
        System.out.println(parts);
    }
}
