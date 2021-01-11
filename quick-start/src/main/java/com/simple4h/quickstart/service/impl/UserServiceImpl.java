package com.simple4h.quickstart.service.impl;

import com.simple4h.quickstart.dao.UserMapper;
import com.simple4h.quickstart.domain.User;
import com.simple4h.quickstart.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO:
 *
 * @author Simple4H
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer userId) {
        return userMapper.selectById(userId);
    }
}