package com.flyonsky.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luowengang
 * @date 2022/11/27 22:36
 */
@Configuration
public class MeterRegistryConfig {

    @Bean
    MeterRegistryCustomizer meterRegistryCustomizer(@Value("${spring.application.name}") String applicationName, MeterRegistry meterRegistry) {
        return meterRegistry1 -> {
            meterRegistry.config().commonTags("application", applicationName);
        };
    }
}
