package com.simple4h.service.impl;

import com.simple4h.common.ServerResponse;
import com.simple4h.dao.UserMapper;
import com.simple4h.domain.User;
import com.simple4h.service.IUserService;
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

    @Override
    public ServerResponse<User> getUserInfo(Integer userId) {
        return ServerResponse.createBySuccess(userMapper.selectByPrimaryKey(userId));
    }
}
