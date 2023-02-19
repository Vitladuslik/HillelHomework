package com.cache.config;

import com.cache.logic.impl.CacheImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(name = "CacheImpl")
    public CacheImpl getHelloWorld() {
        return new CacheImpl();
    }
}
