package com.flyonsky.mapper;

import com.flyonsky.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author luowengang
 * @date 2020/4/6 8:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInster(){

        User user = new User();
        user.setAge(20);
        user.setName("Jone");
        user.setEmail("Jone@baomidou.com");

        this.userMapper.insert(user);

        user = new User();
        user.setAge(20);
        user.setName("Jack");
        user.setEmail("Jack@baomidou.com");

        this.userMapper.insert(user);


        user = new User();
        user.setAge(28);
        user.setName("Tom");
        user.setEmail("Tom@baomidou.com");

        this.userMapper.insert(user);

    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
