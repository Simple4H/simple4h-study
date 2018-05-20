package com.simple.controller;

import com.simple.common.Const;
import com.simple.common.ServerResponse;
import com.simple.pojo.User;
import com.simple.service.IEmailService;
import com.simple.util.CookieUtil;
import com.simple.util.JsonUtil;
import com.simple.util.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/email/")
@Controller
public class EmailController {

    @Autowired
    private IEmailService iEmailService;


    @RequestMapping(value = "send_email.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sendEmail(HttpServletRequest request) {
        // 获取cookie
        String loginToken = CookieUtil.readLoginToken(request);
        // 从redis取得用户信息
        String userJson = RedisPoolUtil.get(loginToken);
        // json序列化成User对象
        User user = JsonUtil.string2Obj(userJson, User.class);
        if (user != null) {
            String userEmail = user.getEmail();
            ServerResponse userCheckCode = iEmailService.sendEmail(userEmail);
            if (userCheckCode.isSuccess()) {
                String jsonCheckCode = JsonUtil.obj2String(userCheckCode.getData());
                // 将验证码存入Redis中，邮箱名作为关键字
                RedisPoolUtil.setEx(user.getEmail(), Const.RedisCacheExtime.CHECK_CODE, jsonCheckCode);
            }
            return userCheckCode;
        }
        return ServerResponse.createByErrorMessage("用户未登录");

    }

    @RequestMapping(value = "check_email_token.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse checkEmailToken(String token, HttpServletRequest request) {
        // 获取cookie
        String loginToken = CookieUtil.readLoginToken(request);
        // 从redis取得用户信息
        String userJson = RedisPoolUtil.get(loginToken);
        // json序列化成User对象
        User user = JsonUtil.string2Obj(userJson, User.class);
        if (user != null) {
            return iEmailService.checkEmailToken(token, user.getEmail());
        }
        return ServerResponse.createByErrorMessage("用户未登录");
    }
}
