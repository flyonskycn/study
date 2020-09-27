package com.flyonsky.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/27 21:06
 */
public class StringsExplainedTest {

    @Test
    public void testJoiner(){
        Joiner joiner = Joiner.on("; ").skipNulls();
        String value = joiner.join("Harry", null, "Ron", "Hermione");

        System.out.println(value);
    }

    @Test
    public void testSplitter(){
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux"));
    }

    @Test
    public void testCharMatcher(){
        String noControl = CharMatcher.javaIsoControl().removeFrom("abc");
        System.out.println(noControl);
        String theDigits = CharMatcher.javaDigit().retainFrom("12345");
        System.out.println(theDigits);
    }
}
