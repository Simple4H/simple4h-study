package com.simple;

import com.simple.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudyApplicationTests {

    @Autowired
    private IEmailService iEmailService;

    @Test
    public void SendSimpleEmail() {
        iEmailService.sendEmail("crescentcxm@gmail.com",
                "测试简单邮件发送",
                "如果你收到这条邮件，说明测试成功!");
    }

    @Test
    public void sendHtmlEmail() throws MessagingException {
        String content = "<html>\n" +
                "<body>\n" +
                "<h3>如果你收到这条邮件，说明测试成功!</h3>" +
                "</body>\n" +
                "</html>";
        iEmailService.sendHtmlEmail("crescentcxm@gmail.com",
                "测试简单邮件发送",
                content);
    }

    @Test
    public void sendAttachEmail() throws MessagingException {
        String filePath = "/Users/simple/Downloads/7bd8b645gy1fuz1sd2chwj20k072snpd.jpg";
        iEmailService.sendAttachmentEmail("crescentcxm@gmail.com",
                "邮箱附件测试",
                "如果你收到这条邮件而且看到附件，说明测试成功!",
                filePath);
    }

}
