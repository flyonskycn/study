package com.flyonsky.guava;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import org.junit.Test;

import java.util.Map;

/**
 * @author luowengang
 * @date 2020/9/24 21:53
 */
public class ClassToInstanceMapTest {

    @Test
    public void testClassToInstanceMap(){
        ClassToInstanceMap<Number> classToInstanceMap = MutableClassToInstanceMap.create();
        classToInstanceMap.putInstance(Integer.class, 10);
        classToInstanceMap.putInstance(Long.class, 100L);
        classToInstanceMap.putInstance(Long.class, 10000L);

        System.out.println(classToInstanceMap.toString());

        for(Map.Entry<Class<? extends Number>, Number> entry : classToInstanceMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
