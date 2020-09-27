package com.flyonsky.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.*;
import lombok.Data;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/27 22:36
 */
public class HashingTest {

    @Test
    public void testHashing(){
        HashFunction hf = Hashing.sha512();
        Person person = new Person(1120,"第一姓名","第二名称",2010);
        HashCode hc = hf.newHasher()
                .putLong(1000L)
                .putString("昆明", Charsets.UTF_8)
                .putObject(person, new Funnel<Person>() {
                            @Override
                            public void funnel(Person person, PrimitiveSink into) {
                                into.putInt(person.id)
                                    .putString(person.firstName, Charsets.UTF_8)
                                    .putString(person.lastName, Charsets.UTF_8)
                                    .putInt(person.birthYear);
                            }
                        })
                .hash();

        System.out.println(hc.asLong());
    }

    @Data
    public static class Person{
        private final int id;
        private final String firstName;
        private final String lastName;
        private final int birthYear;
    }
}
