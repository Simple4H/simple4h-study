package com.simple4h.sample.controller;

import com.simple4h.autoconfiguration.service.AutoService;
import com.simple4h.sample.lock.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author Create By Simple4H
 * date 2020-09-30 16:06
 */
@RestController
@RequestMapping("/sample/")
public class SampleController {

    @Autowired
    private AutoService autoService;

    @Value("author")
    private String author;

    @GetMapping("auto")
    public String auto() {
        return autoService.sayWhat();
    }

    @GetMapping("consulConfig")
    public String consulConfig() {
        return author;
    }

    @RedisLock(key = "redis_lock")
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}