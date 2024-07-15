package com.simple4h.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.simple4h.demo.mapper")
public class Simple4hDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Simple4hDemoApplication.class, args);
    }

}
