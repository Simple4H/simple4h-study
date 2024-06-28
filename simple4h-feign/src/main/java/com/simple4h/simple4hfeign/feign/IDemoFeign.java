package com.simple4h.simple4hfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * simple4h-demo Feign
 *
 * @author Simple4H
 */
@FeignClient(name = "simple4h-demo", path = "/user")
public interface IDemoFeign {

    @GetMapping("/getById")
    Object getById(@RequestParam Long id);

    @GetMapping("/{id}")
    Object pathVal(@PathVariable("id") Long id);
}
