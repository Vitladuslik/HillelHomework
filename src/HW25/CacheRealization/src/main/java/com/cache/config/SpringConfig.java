package com.cache.config;

import com.cache.service.impl.CacheImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(name = "CacheImpl")
    public CacheImpl getCache() {
        return new CacheImpl();
    }
}
