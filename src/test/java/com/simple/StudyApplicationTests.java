package com.simple;

import com.simple.pojo.User;
import com.simple.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudyApplicationTests {

    @Autowired
    private IUserService iUserService;

    @Test
    public void findAll(){
        List<User> userList = iUserService.selectAllData();
        log.warn("User Data:{}",userList);
    }
}
