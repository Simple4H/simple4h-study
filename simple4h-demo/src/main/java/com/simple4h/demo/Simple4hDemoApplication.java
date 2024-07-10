package com.simple4h.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.simple4h"})
@MapperScan(basePackages = "com.simple4h.demo.mapper")
public class Simple4hDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Simple4hDemoApplication.class, args);
    }

}
