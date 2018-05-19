package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.dao.UserMapper;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse login(String username,String password) {
        User user = userMapper.login(username, password);
        if (user != null){
            return ServerResponse.createBySuccess("登录成功",user);
        }
        return ServerResponse.createByErrorMessage("登录失败");

    }
}
