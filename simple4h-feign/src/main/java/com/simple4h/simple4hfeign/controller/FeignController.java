package com.simple4h.simple4hfeign.controller;

import com.simple4h.simple4hfeign.feign.IDemoFeign;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign Controller
 *
 * @author Simple4H
 */
@RestController
@RequestMapping("/feign/")
public class FeignController {

    @Resource
    private IDemoFeign demoFeign;

    @GetMapping("getById")
    public Object getById(Long id) {
        return demoFeign.getById(id);
    }

    @GetMapping("{id}")
    public Object pathVal(@PathVariable("id") Long id) {
        return demoFeign.pathVal(id);
    }
}
