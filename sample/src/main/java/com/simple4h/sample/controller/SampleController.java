package com.simple4h.sample.controller;

import com.simple4h.sample.feign.IDemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private IDemoFeignService iDemoFeignService;

    @GetMapping("get")
    public String get() {
        return iDemoFeignService.getUserInfo();
    }
}