package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2021/2/13 18:30
 */
public class JoinerTest extends JsonBaseTest {

    @Test
    public void testJoiner(){
        Joiner joiner = Joiner.on("; ").skipNulls();
        printString(joiner.join("Harry", null, "Ron", "Hermione"));

        printString(String.join(",","a","b"));

        // returns "1,5,7"
        printString(Joiner.on(",").join(Lists.newArrayList(1, 5, 7)));
    }
}
