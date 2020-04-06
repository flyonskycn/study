package com.flyonsky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flyonsky.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luowengang
 * @date 2020/4/6 15:02
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
