package com.flyonsky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flyonsky.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luowengang
 * @date 2020/4/6 15:03
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
