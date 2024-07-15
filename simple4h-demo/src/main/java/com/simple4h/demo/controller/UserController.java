package com.simple4h.demo.controller;

import com.simple4h.base.config.ClassAnnotation;
import com.simple4h.base.config.MethodAnnotation;
import com.simple4h.demo.domain.SysUser;
import com.simple4h.demo.service.ISysUserService;
import com.simple4h.demo.service.ITestMultiService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理
 *
 * @author Simple4H
 */
@RequestMapping("/user/")
@RestController
@ClassAnnotation(value = "用户管理")
public class UserController {

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private List<ITestMultiService> testMultiServiceList;

    @MethodAnnotation(value = "通过Id获取")
    @GetMapping("getById")
    public SysUser getById(Long id) {
        return sysUserService.getById(id);
    }

    @MethodAnnotation(value = "restful通过Id获取")
    @GetMapping("{id}")
    public SysUser get(@PathVariable Long id) {
        return sysUserService.getById(id);
    }

    @MethodAnnotation(value = "多方法执行")
    @GetMapping("multi")
    public void multi() {
        testMultiServiceList.forEach(ITestMultiService::execute);
    }
}
