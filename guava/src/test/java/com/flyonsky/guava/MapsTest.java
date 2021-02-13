package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author luowengang
 * @date 2020/9/24 23:27
 */
public class MapsTest extends JsonBaseTest {

    @Test
    public void testMaps(){
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 5);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        // {"b" => 2}
        printString(diff.entriesInCommon());
        // {"c" => (3, 4)}
        printString(diff.entriesDiffering().toString());
        // {"a" => 1}
        printString(diff.entriesOnlyOnLeft());
        // {"d" => 5}
        printString(diff.entriesOnlyOnRight());
    }
}
