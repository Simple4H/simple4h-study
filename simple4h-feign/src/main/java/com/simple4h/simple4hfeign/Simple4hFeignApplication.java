package com.simple4h.simple4hfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages={"com.simple4h"})
@SpringBootApplication
public class Simple4hFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Simple4hFeignApplication.class, args);
    }

}
