package com.flyonsky;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/4/18 18:09
 */
public class ReactivexTest {

    @Test
    public void helloWord(){
        Flowable.rangeLong(1,5000).subscribe(System.out::println);
        Maybe.just("Hello world").subscribe(System.out::println);
    }
}
