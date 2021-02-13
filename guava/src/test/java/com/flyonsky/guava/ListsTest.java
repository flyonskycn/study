package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author luowengang
 * @date 2020/9/24 23:01
 */
public class ListsTest extends JsonBaseTest {

    @Test
    public void testLists(){
        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        printString(countUp);

        // {5, 4, 3, 2, 1}
        List<Integer> countDown = Lists.reverse(countUp);
        printString(countDown);

        // {{1, 2}, {3, 4}, {5}}
        List<List<Integer>> parts = Lists.partition(countUp, 2);
        printString(parts);

        printString(Collections.max(countDown));
    }
}
