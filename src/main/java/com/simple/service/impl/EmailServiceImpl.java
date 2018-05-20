package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("iEmailService")
@Slf4j
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public ServerResponse sendEmail(String email) {
        // 建立邮箱消息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // 发送者
        simpleMailMessage.setFrom(sender);

        // 接收者
        simpleMailMessage.setTo(email);

        // 发送标题
        simpleMailMessage.setSubject("Hello~");

        // 发送内容
        String token = "666666";
        simpleMailMessage.setText("你的验证码是:" + token);

        try {
            javaMailSender.send(simpleMailMessage);
            return ServerResponse.createBySuccess("发送成功",token);
        } catch (MailException e) {
            e.printStackTrace();
            log.error("发送邮件异常:{}",e);
            return ServerResponse.createBySuccessMessage("发送失败");
        }
    }
}
