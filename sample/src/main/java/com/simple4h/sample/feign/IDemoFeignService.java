package com.simple4h.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * author Create By Simple4H
 * date 2020-09-30 16:15
 */
@FeignClient(value = "demo-service", configuration = FeignClientsConfiguration.class)
public interface IDemoFeignService {

//    @GetMapping(value = "/user/get_info")
//    String getUserInfo();

    @RequestMapping(value = "/user/get_info", method = RequestMethod.GET)
    String getUserInfo2();
}
