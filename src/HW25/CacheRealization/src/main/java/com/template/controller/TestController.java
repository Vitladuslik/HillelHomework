package com.template.controller;

import com.template.config.SpringConfig;
import com.template.service.impl.CacheImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    CacheImpl cacheImpl = context.getBean("CacheImpl", CacheImpl.class);

    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, "ping"));
        return "work - OK";
    }
    private static final Logger informer = LoggerFactory.getLogger("informer");

    @GetMapping("/put")
    public String put(String cacheName, String key, Object o) {
        informer.info("Running 'put(String cacheName, String key, Object o)' method");
        boolean result = cacheImpl.put(cacheName, key, o);
        return "Put " + o.toString() + " in cache " + cacheName + "; result : " + result;
    }
    @GetMapping("/get")
    public String get(String cacheName, String key) {
        informer.info("Running 'get(String cacheName, String key)' method");

        return "Retrieved " + cacheImpl.get(cacheName, key).toString() + " from " + cacheName;
    }
    @GetMapping("/clear()")
    public String clear() {
        informer.info("Running 'clear()' method");
        if (cacheImpl.clear()) {
            return "Successfully cleared the whole cache";
        } else return "Couldn't clear the whole cache";
    }
    @GetMapping("/clear")
    public String clear(String cacheName) {
        informer.info("Running 'clear(String cacheName)' method");
        if (cacheImpl.clear(cacheName)) {
            return cacheName + " cleared successfully";
        } else return "Couldn't clear " + cacheName;
    }
    @GetMapping("/isCacheExist")
    public boolean isCacheExist(String cacheName) {
        informer.info("Running 'isCacheExist(String cacheName)' method");
        return cacheImpl.isCacheExist(cacheName);
    }
}
