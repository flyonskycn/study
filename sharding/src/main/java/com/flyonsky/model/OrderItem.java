package com.flyonsky.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author luowengang
 * @date 2020/4/6 10:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order_item")
public class OrderItem implements Serializable {
    @TableId("id")
    private Long id;
    @TableField("order_id")
    private Long orderId;
    @TableField("item")
    private String item;
    @TableField("user_id")
    private Long userId;
}
