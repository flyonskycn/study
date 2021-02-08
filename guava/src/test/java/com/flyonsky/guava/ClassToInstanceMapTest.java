package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import org.junit.Test;

import java.util.Map;

/**
 * @author luowengang
 * @date 2020/9/24 21:53
 */
public class ClassToInstanceMapTest extends JsonBaseTest {

    @Test
    public void testClassToInstanceMap(){
        ClassToInstanceMap<Number> classToInstanceMap = MutableClassToInstanceMap.create();
        classToInstanceMap.putInstance(Integer.class, 10);
        classToInstanceMap.putInstance(Long.class, 100L);
        classToInstanceMap.putInstance(Long.class, 10000L);

        printString(classToInstanceMap);

        for(Map.Entry<Class<? extends Number>, Number> entry : classToInstanceMap.entrySet()){
            printString(entry.getKey() + ":" + entry.getValue());
        }
    }
}
