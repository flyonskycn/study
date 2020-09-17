package com.flyonsky.guava;

import static com.google.common.base.Preconditions.*;

/**
 * @author luowengang
 * @date 2020/9/17 21:40
 */
public class PreconditionsDemo {

    public Integer sum(Integer a,Integer b){
        checkNotNull(a, "param a is null");
        checkNotNull(b, "param a is null");

        return a + b;
    }
}
