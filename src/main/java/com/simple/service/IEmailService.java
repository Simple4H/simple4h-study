package com.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Create By S I M P L E On 2018/09/05 21:16:57
 */
@Service
public class IEmailService {

    // 通过@value将邮箱赋值给字段
    @Value("${spring.mail.username}")
    private String myself;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发送给谁
        simpleMailMessage.setTo(to);
        // 发送标题
        simpleMailMessage.setSubject(subject);
        // 发送内容
        simpleMailMessage.setText(content);
        // 发送者
        simpleMailMessage.setFrom(myself);
        // 发送邮件
        javaMailSender.send(simpleMailMessage);

    }
}
