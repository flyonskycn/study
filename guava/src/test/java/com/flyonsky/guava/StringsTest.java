package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.base.Strings;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2021/2/20 22:20
 */
public class StringsTest extends JsonBaseTest {

    @Test
    public void testNullToEmpty(){
        printString(Strings.nullToEmpty(null));
        Assert.assertEquals("",Strings.nullToEmpty(null));
        printString(Strings.nullToEmpty("abc"));
    }

    @Test
    public void testCommonPrefix(){
        String prefix = Strings.commonPrefix("abcedf","abcdefc");
        printString(prefix);
        Assert.assertEquals("abc",prefix);

    }

    @Test
    public void testLenientFormat(){
        String str = Strings.lenientFormat("%s,name%s", "abc");
        printString(str);
    }

    @Test
    public void testPadStart(){
        printString(Strings.padStart("abc",10,'f'));
    }

    @Test
    public void testPadEnd(){
        printString(Strings.padEnd("abc",10,'f'));
    }
}
