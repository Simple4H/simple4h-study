package com.simple4h.service.impl;

import com.simple4h.common.ServerResponse;
import com.simple4h.dao.UserMapper;
import com.simple4h.domain.User;
import com.simple4h.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * author Create By Simple4H
 * date 2020-09-25 10:14
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ServerResponse<User> getUserInfo(Integer userId) {
        stringRedisTemplate.opsForValue().set("a", "a");
        stringRedisTemplate.expire("a", 10L, TimeUnit.SECONDS);
        return ServerResponse.createBySuccess(userMapper.selectByPrimaryKey(userId));
    }
}
