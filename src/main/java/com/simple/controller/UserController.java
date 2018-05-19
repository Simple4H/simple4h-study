package com.simple.controller;

import com.simple.common.Const;
import com.simple.common.ServerResponse;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/user/")
@Controller
public class UserController {

    // TODO: Spring session 与 Redis 集成
    // TODO: cookie

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse login(String username, String password, HttpSession session) {
        ServerResponse result = iUserService.login(username, password);
        if(result.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,result);
            return result;
        }
        return null;
    }

    @RequestMapping(value = "get_info.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getInfo(HttpSession session) {
        return ServerResponse.createBySuccess("成功",session.getAttribute(Const.CURRENT_USER));
    }
}
