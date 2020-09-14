package com.flyonsky.guava;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/14 23:19
 */
public class OptionalTest {

    @Test(expected = IllegalStateException.class)
    public void testFromNullable(){
        Optional<Integer> optional = Optional.fromNullable(null);

        optional.get();
    }
}
