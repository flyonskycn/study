package com.flyonsky.spi.imp;

import com.flyonsky.spi.SpiService;

/**
 * @author luowengang
 * @date 2022/1/27 21:00
 */
public class FirstSpiService implements SpiService {

    @Override
    public void execute() {
        System.out.println("first service execute");
    }
}
