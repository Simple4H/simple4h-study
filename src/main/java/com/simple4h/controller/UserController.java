package com.simple4h.controller;

import com.simple4h.common.ServerResponse;
import com.simple4h.domain.User;
import com.simple4h.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author Create By Simple4H
 * date 2020-09-25 10:17
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("{userId}")
    public ServerResponse<User> getUserInfo(@PathVariable Integer userId) {
        return iUserService.getUserInfo(userId);
    }
}
