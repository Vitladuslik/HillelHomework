package com.sort.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, "ping"));
        return "work - OK";
    }

    @GetMapping("/sort")
    public String sort(@RequestPart File file) {
        log.info(String.format(CALL_ENDPOINT, "sort"));
        return "work - OK";
    }

}
