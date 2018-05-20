package com.simple.controller;

import com.simple.common.Const;
import com.simple.common.ServerResponse;
import com.simple.pojo.User;
import com.simple.service.IEmailService;
import com.simple.service.IUserService;
import com.simple.util.CookieUtil;
import com.simple.util.JsonUtil;
import com.simple.util.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping(value = "/user/")
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IEmailService iEmailService;

    // Spring session框架集成
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse login(String username, String password, HttpSession session) {
        ServerResponse result = iUserService.login(username, password);
        if (result.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, result);
            return result;
        }
        return null;
    }

    @RequestMapping(value = "get_info.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getInfo(HttpSession session) {
        return ServerResponse.createBySuccess("成功", session.getAttribute(Const.CURRENT_USER));
    }

    // redis login
    @RequestMapping(value = "redis_login.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse redisLogin(String username, String password, HttpServletResponse httpServletResponse, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            CookieUtil.writeLoginToken(httpServletResponse, session.getId());
            RedisPoolUtil.setEx(session.getId(), Const.RedisCacheExtime.REDIS_SESSION_EXTIME, JsonUtil.obj2String(response.getData()));
        }
        return response;
    }

    @RequestMapping(value = "redis_get_info.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse redisGetInfo(HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        String userJson = RedisPoolUtil.get(loginToken);
        User user = JsonUtil.string2Obj(userJson, User.class);
        return ServerResponse.createBySuccess("获取成功", user);
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse register(User user, HttpSession session) {
        ServerResponse response = iUserService.register(user);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, user);
            return response;
        }
        return response;
    }

//    @RequestMapping(value = "check_email.do", method = RequestMethod.GET)
//    @ResponseBody
//    public ServerResponse checkEmail(HttpSession session) {
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        // 获取用户邮箱
//        String userEmail = user.getEmail();
//        // 发送邮件
//        ServerResponse response = iEmailService.sendEmail(userEmail);
//        if (response.isSuccess()) {
//            String token = (String) response.getData();
//            session.setAttribute(Const.CURRENT_USER, user);
//            return iUserService.register(user, token);
//        }
//        return response;
//    }
}