package com.simple4h.quickstart.controller;

import com.simple4h.quickstart.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO:
 *
 * @author Simple4H
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("{id}")
    public Object getUserInfo(@PathVariable("id") Integer id) {
        return iUserService.getUserById(id);
    }
}
