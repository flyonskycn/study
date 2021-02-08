package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/24 21:11
 */
public class BiMapTest extends JsonBaseTest {

    @Test
    public void testBiMap(){
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("a",10);
        printString(biMap);
        printString(biMap.get("a"));

        BiMap<Integer,String> integerBiMap = biMap.inverse();

        printString(integerBiMap);
        printString(integerBiMap.get(10));
    }
}
