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
 * @date 2020/4/6 10:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order implements Serializable {

    @TableId("order_id")
    private Long orderId;

    @TableField("user_id")
    private Long userId;

    @TableField("name")
    private String name;
}
