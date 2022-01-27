package com.flyonsky.spi;

import java.util.ServiceLoader;

/**
 * @author luowengang
 * @date 2022/1/27 20:58
 */
public class SpiMain {

    public static void main(String[] args){
        ServiceLoader<SpiService> spiServices = ServiceLoader.load(SpiService.class);
        for(SpiService service : spiServices){
            service.execute();
        }
    }
}
