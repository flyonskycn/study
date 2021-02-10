package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

/**
 * @author luowengang
 * @date 2020/9/24 22:48
 */
public class IterablesTest extends JsonBaseTest {

    @Test
    public void testIterables(){
        List<String> list = Lists.newArrayList("a", "b", "c");
        List<String> list2 = Lists.newArrayList("e", "f", "g");

        List<String> stringList = Lists.newArrayList(Iterables.concat(list, list2));

        printString(stringList);

        printString(Iterables.frequency(stringList,"a"));

        Iterable<Integer> concatenated = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6));
        printString(concatenated.toString());

        printString(Iterables.partition(concatenated,2).toString());
        printString(Iterables.getLast(concatenated));
    }
}
