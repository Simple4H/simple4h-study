package com.simple4h.demo.controller;

import com.simple4h.common.response.ServerResponse;
import com.simple4h.demo.domain.User;
import com.simple4h.demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author Create By Simple4H
 * date 2020-09-25 10:17
 */
@RestController
@RequestMapping("/demo/")
public class DemoController {

    @Resource
    private IUserService iUserService;

    @GetMapping("{userId}")
    public ServerResponse<User> getUserInfo(@PathVariable Integer userId) {
        return iUserService.getUserInfo(userId);
    }

    @GetMapping("get_info")
    public String getUserInfo() {
        return "Simple4H";
    }
}
