package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author luowengang
 * @date 2020/9/24 20:32
 */
public class MultimapTest extends JsonBaseTest {

    @Test
    public void testMultimap(){
        ListMultimap<String,String> listMultimap = MultimapBuilder.hashKeys().arrayListValues().build();
        listMultimap.put("a", "a");
        listMultimap.put("a", "b");
        listMultimap.put("a", "c");
        listMultimap.put("a", "d");
        listMultimap.put("a", "e");

        System.out.println(listMultimap.toString());
        System.out.println(listMultimap.size());
        Assert.assertEquals(5,listMultimap.size());

        List<String> list = listMultimap.get("a");
        list.add("f");

        System.out.println(listMultimap.toString());
        Assert.assertEquals(6,listMultimap.size());

        for(Map.Entry<String, String> entry: listMultimap.entries()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        for(String key : listMultimap.keySet()){
            System.out.println(listMultimap.get(key));
        }
    }

    @Test
    public void testSetMultimap(){
        SetMultimap<String, String> stringSetMultimap = MultimapBuilder.hashKeys().hashSetValues().build();
        stringSetMultimap.put("a", "a");
        stringSetMultimap.put("b", "b");
        stringSetMultimap.put("c", "c");
        stringSetMultimap.put("d", "d");
        stringSetMultimap.put("a", "e");

        printString(stringSetMultimap.asMap());
        printString(stringSetMultimap.keys());
        printString(stringSetMultimap.keys().entrySet());
        printString(stringSetMultimap.keySet());
        printString(stringSetMultimap.values());
    }
}
