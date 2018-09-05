package com.simple;

import com.simple.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudyApplicationTests {

    @Autowired
    private IEmailService iEmailService;

    @Test
    public void SendSimpleEmail(){
        iEmailService.sendEmail("crescentcxm@gmail.com",
                "测试简单邮件发送",
                "如果你收到这条邮件，说明测试成功!");
    }

}
