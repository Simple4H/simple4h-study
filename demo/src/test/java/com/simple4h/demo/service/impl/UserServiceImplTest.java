package com.simple4h.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.demo.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * TODO:
 *
 * @author Simple4H
 */
@SpringBootTest
@Slf4j
//@ContextConfiguration(classes = {
//        UserServiceImpl.class,
//        UserMapper.class
//})
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void getUsersByAge() {
        log.info(JSONObject.toJSONString(userServiceImpl.getUsersByAge(13)));
    }
}