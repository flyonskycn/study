package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/24 22:15
 */
public class RangeMapTest extends JsonBaseTest {

    @Test
    public void testRangeMap(){
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        // {[1, 10] => "foo"}
        rangeMap.put(Range.closed(1, 10), "foo");
        printString(rangeMap.toString());

        // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar");
        printString(rangeMap.toString());

        // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo", (10, 20) => "foo"}
        rangeMap.put(Range.open(10, 20), "foo");
        printString(rangeMap.toString());

        // {[1, 3] => "foo", (3, 5) => "bar", (11, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11));
        printString(rangeMap.toString());

        printString(rangeMap.get(15));

        Assert.assertEquals("foo",rangeMap.get(15));
    }
}
