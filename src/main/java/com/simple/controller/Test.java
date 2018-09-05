package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By S I M P L E On 2018/09/05 20:21:15
 */
@Controller
@RequestMapping(value = "test")
public class Test {

    @RequestMapping(value = "hello.do",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello world!";
    }
}
