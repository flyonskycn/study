package com.flyonsky.service;

import com.flyonsky.mapper.OrderItemMapper;
import com.flyonsky.mapper.OrderMapper;
import com.flyonsky.mapper.UserMapper;
import com.flyonsky.model.Order;
import com.flyonsky.model.OrderItem;
import com.flyonsky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author luowengang
 * @date 2020/4/6 15:11
 */
@Service
@Transactional
public class ShardingService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    public void save(User user, Order order, OrderItem orderItem){
        Assert.notNull(user,"mdthod save param user is null");
        Assert.notNull(order,"mdthod save param order is null");
        Assert.notNull(orderItem,"mdthod save param orderItem is null");

        this.userMapper.insert(user);
        this.orderMapper.insert(order);
        this.orderItemMapper.insert(orderItem);
    }
}
