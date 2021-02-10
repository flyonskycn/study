package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/24 22:08
 */
public class RangeSetTest extends JsonBaseTest {

    @Test
    public void testRangeSet(){
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        // {[1, 10]}
        rangeSet.add(Range.closed(1, 10));
        printString(rangeSet.toString());
        printString(rangeSet.contains(5));
        printString(rangeSet.complement().toString());

        ImmutableRangeSet<Integer> integerImmutableRangeSet = ImmutableRangeSet.copyOf(rangeSet);
        ImmutableSortedSet<Integer> immutableSortedSet = integerImmutableRangeSet.asSet(DiscreteDomain.integers());
        printString(immutableSortedSet);

        printString(rangeSet.subRangeSet(Range.closed(5,15)).toString());

        // disconnected range: {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(11, 15));
        printString(rangeSet.toString());
        // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.closedOpen(15, 20));
        printString(rangeSet.toString());


        // empty range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0));
        printString(rangeSet.toString());

        // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}
        rangeSet.remove(Range.open(5, 10));
        printString(rangeSet.toString());

        printString(rangeSet.encloses(Range.closed(15,20)));

        printString("span():" + rangeSet.span().toString());

    }
}
