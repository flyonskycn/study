package com.flyonsky.guava;

import com.google.common.collect.ImmutableList;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author luowengang
 * @date 2020/9/23 21:02
 */
public class ImmutableCollectionTest {

    @Test
    public void testImmutable(){
        User user = new User();
        user.setAge(10);
        user.setName("abc");
        List<User> list = new ArrayList<>();
        list.add(user);
        ImmutableList<User> userImmutableList = ImmutableList.copyOf(list);

        user = new User();
        user.setAge(20);
        user.setName("efg");

        list.add(user);

        Collection<User> collection = Collections.unmodifiableCollection(list);

        System.out.println(userImmutableList.size());
        Assert.assertEquals(1,userImmutableList.size());

        System.out.println(collection.size());
        Assert.assertEquals(2,collection.size());
    }

    @Data
    public static class User implements Serializable{
        private String name;
        private Integer age;
    }
}
