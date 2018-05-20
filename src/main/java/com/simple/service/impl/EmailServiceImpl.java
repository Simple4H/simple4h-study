package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.service.IEmailService;
import com.simple.util.JsonUtil;
import com.simple.util.RedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        simpleMailMessage.setSubject("您好，欢迎注册~");

        // 发送内容
        int token = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
        simpleMailMessage.setText("您的验证码是:" + token);

        try {
            javaMailSender.send(simpleMailMessage);
            return ServerResponse.createBySuccess("发送成功", token);
        } catch (MailException e) {
            e.printStackTrace();
            log.error("发送邮件异常:{}", e);
            return ServerResponse.createBySuccessMessage("发送失败");
        }
    }

    public ServerResponse checkEmailToken(String token,String email) {
        // 先取Redis中的验证码，并且Json反序列化
        String jsonResponse = JsonUtil.string2Obj(RedisPoolUtil.get(email),String.class);
        if (jsonResponse != null) {
            if (StringUtils.equals(jsonResponse,token)) {
                return ServerResponse.createBySuccessMessage("邮箱验证成功");
            }
            return ServerResponse.createByErrorMessage("邮箱验证失败");
        }
        return ServerResponse.createByErrorMessage("验证码超时，请重新获取");

    }
}
