package com.flyonsky.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luowengang
 * @date 2020/4/5 22:52
 */
@Data
public class City implements Serializable {
    private Long id;
    private String name;
    private String state;
    private String country;
}
