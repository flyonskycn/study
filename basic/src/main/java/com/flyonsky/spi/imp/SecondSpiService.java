package com.flyonsky.spi.imp;

import com.flyonsky.spi.SpiService;

/**
 * @author luowengang
 * @date 2022/1/27 21:01
 */
public class SecondSpiService implements SpiService {

    @Override
    public void execute() {
        System.out.println("second service execute");
    }
}
