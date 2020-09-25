package com.simple4h.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.common.response.ServerResponse;
import com.simple4h.common.service.IKafkaService;
import com.simple4h.common.service.IRedisService;
import com.simple4h.demo.dao.UserMapper;
import com.simple4h.demo.domain.User;
import com.simple4h.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author Create By Simple4H
 * date 2020-09-25 10:14
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IKafkaService iKafkaService;

    @Autowired
    private IRedisService iRedisService;

    @Override
    public ServerResponse<User> getUserInfo(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        iRedisService.setKeyAndValueAndExpire("#redis.user.key." + userId,
                JSONObject.toJSONString(user),
                10000L);
        iKafkaService.sendKafkaDefaultTopicMessage("simple4h");

        return ServerResponse.createBySuccess(user);
    }
}
