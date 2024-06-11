package com.simple4h.demo.service.impl;

import com.simple4h.demo.service.ISysUserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple4h.demo.mapper.SysUserMapper;
import com.simple4h.demo.domain.SysUser;

/**
 * 用户实现
 *
 * @author Simple4H
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
