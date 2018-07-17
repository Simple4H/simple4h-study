package com.simple.controller;

import com.simple.common.Const;
import com.simple.common.ServerResponse;
import com.simple.pojo.User;
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

    //  Spring Session框架集成
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse login(String username, String password, HttpSession session) {
        ServerResponse result = iUserService.login(username, password);
        if (result.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, result.getData());
            return result;
        }
        return result;
    }

    // 获取用户信息
    @RequestMapping(value = "get_info.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess("成功", user);
        }
        return ServerResponse.createByErrorMessage("请登录");
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
    // 获取用户信息
    @RequestMapping(value = "redis_get_info.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse redisGetInfo(HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        String userJson = RedisPoolUtil.get(loginToken);
        User user = JsonUtil.string2Obj(userJson, User.class);
        if(user != null){
            return ServerResponse.createBySuccess("获取成功", user);
        }
        return ServerResponse.createByErrorMessage("请登录");
    }
}