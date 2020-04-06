package com.flyonsky.model;

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
public class OrderItem implements Serializable {

    private Long id;
    private Long orderId;
    private String item;
    private Long userId;
}
