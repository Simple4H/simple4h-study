package com.simple4h.demo.controller;

import com.simple4h.demo.domain.SysUser;
import com.simple4h.demo.service.ISysUserService;
import com.simple4h.demo.service.ITestMultiService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理
 *
 * @author Simple4H
 */
@RequestMapping("/user/")
@RestController
public class UserController {

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private List<ITestMultiService> testMultiServiceList;

    @GetMapping("getById")
    public SysUser getById(Long id) {
        return sysUserService.getById(id);
    }

    @GetMapping("{id}")
    public SysUser get(@PathVariable Long id) {
        return sysUserService.getById(id);
    }

    @GetMapping("multi")
    public void multi() {
        testMultiServiceList.forEach(ITestMultiService::execute);
    }
}
