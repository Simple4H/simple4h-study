package com.simple.controller.redirect;

import com.simple.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String email() {
        return "email";
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
    public String checkEmail() {
        return "checkEmail";
    }
}
