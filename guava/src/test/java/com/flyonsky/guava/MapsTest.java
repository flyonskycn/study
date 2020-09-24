package com.flyonsky.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author luowengang
 * @date 2020/9/24 23:27
 */
public class MapsTest {

    @Test
    public void testMaps(){
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 5);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        // {"b" => 2}
        System.out.println(diff.entriesInCommon());
        // {"c" => (3, 4)}
        System.out.println(diff.entriesDiffering());
        // {"a" => 1}
        System.out.println(diff.entriesOnlyOnLeft());
        // {"d" => 5}
        System.out.println(diff.entriesOnlyOnRight());
    }
}
