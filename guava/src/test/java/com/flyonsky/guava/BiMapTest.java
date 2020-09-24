package com.flyonsky.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/24 21:11
 */
public class BiMapTest {

    @Test
    public void testBiMap(){
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("a",10);
        System.out.println(biMap.get("a"));

        BiMap<Integer,String> integerBiMap = biMap.inverse();

        System.out.println(integerBiMap.get(10));
    }
}
