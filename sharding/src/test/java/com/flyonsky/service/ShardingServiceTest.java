package com.flyonsky.service;

import com.flyonsky.model.Order;
import com.flyonsky.model.OrderItem;
import com.flyonsky.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luowengang
 * @date 2020/4/6 15:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingServiceTest {

    @Autowired
    private ShardingService shardingService;

    @Test
    public void testSave(){
        User user = new User();
        user.setUserId(1L);
        user.setName("测试用户1");
        user.setAge(20);
        user.setEmail("test1@gmail.com");

        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setOrderId(1L);
        order.setName("测试订单1");

        OrderItem orderItem = new OrderItem();
        orderItem.setUserId(user.getUserId());
        orderItem.setOrderId(order.getOrderId());
        orderItem.setItem("订单明细1");

        this.shardingService.save(user, order, orderItem);


        user = new User();
        user.setUserId(2L);
        user.setName("测试用户2");
        user.setAge(21);
        user.setEmail("test2@gmail.com");

        order = new Order();
        order.setUserId(user.getUserId());
        order.setOrderId(2L);
        order.setName("测试订单12");

        orderItem = new OrderItem();
        orderItem.setUserId(user.getUserId());
        orderItem.setOrderId(order.getOrderId());
        orderItem.setItem("订单明细2");
        this.shardingService.save(user, order, orderItem);
    }
}
