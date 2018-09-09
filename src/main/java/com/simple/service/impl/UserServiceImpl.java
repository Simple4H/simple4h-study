package com.simple.service.impl;

import com.simple.dao.UserDao;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By S I M P L E On 2018/09/09 13:45:01
 */
@Service("iUserService")
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public List<User> selectAllData() {
        return userDao.findAll();
    }
}
