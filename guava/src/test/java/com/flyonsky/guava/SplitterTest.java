package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2021/2/13 20:21
 */
public class SplitterTest extends JsonBaseTest {

    @Test
    public void testSplitter(){
        printString(",a,,b,".split(","));

        printString(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux"));
    }
}
