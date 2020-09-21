package com.flyonsky.guava;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Ordering;
import org.junit.Test;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luowengang
 * @date 2020/9/21 21:33
 */
public class OrderingTest {

    @Test
    public void test1(){
        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, String>() {
            public String apply(Foo foo) {
                return foo.sortedBy;
            }
        });

        List<Foo> fooList = new ArrayList<>();

        Foo foo = new Foo();
        foo.sortedBy = "abc";
        fooList.add(foo);

        foo = new Foo();
        fooList.add(foo);

        List<Foo> foos = ordering.sortedCopy(fooList);

        foos.forEach(p->System.out.println(p));
    }

    public static class Foo implements Serializable {
        @Nullable
        String sortedBy;
        int notSortedBy;

        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            Foo foo = (Foo) o;
            return notSortedBy == foo.notSortedBy &&
                    Objects.equal(sortedBy, foo.sortedBy);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(sortedBy, notSortedBy);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("sortedBy",sortedBy)
                    .add("notSortedBy",notSortedBy)
                    .toString();
        }
    }
}
