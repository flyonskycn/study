package com.flyonsky;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author luowengang
 * @date 2020/4/5 20:55
 */
@SpringBootApplication
public class Application {
    public static void main(String... args){
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.run(args);
    }
}
