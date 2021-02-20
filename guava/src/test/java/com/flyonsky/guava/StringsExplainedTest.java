package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/27 21:06
 */
public class StringsExplainedTest extends JsonBaseTest {

    @Test
    public void testJoiner(){
        Joiner joiner = Joiner.on("; ").skipNulls();
        String value = joiner.join("Harry", null, "Ron", "Hermione");

        printString(value);
    }

    @Test
    public void testSplitter(){
        printString(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux"));
    }

    @Test
    public void testCharMatcher(){
        String noControl = CharMatcher.javaIsoControl().removeFrom("for");
        printString(noControl);
        String theDigits = CharMatcher.javaDigit().retainFrom("12345abc");
        printString(theDigits);
    }

    @Test
    public void testCaseFormat(){
        // returns "constantName"
        String name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");
        printString(name);
        Assert.assertEquals("constantName",name);
    }
}
