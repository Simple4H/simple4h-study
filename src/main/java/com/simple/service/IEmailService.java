package com.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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

    // 简单文本邮件
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

    public void sendHtmlEmail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(myself);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content,true);
        javaMailSender.send(mimeMessage);
    }
}
