package com.example.blogo.myblogo.account.controller;

import com.example.blogo.myblogo.account.domain.User;
import com.example.blogo.myblogo.account.service.LoginService;
import com.example.blogo.myblogo.account.views.TotalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 * @author  fan
 */
@RestController
@RequestMapping("user")
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    //有验证码的登录
    @RequestMapping("loginWithCode")
    public TotalUser login(@RequestParam String userNme, @RequestParam String password, @RequestParam String checkCode){
        return loginService.login(userNme,password,checkCode);
    }
    @RequestMapping("login")
    public TotalUser login(@RequestParam String userNme,@RequestParam String password){
       return loginService.login(userNme,password);
    }
    @RequestMapping("register")
    public TotalUser register(@RequestParam String userNme,@RequestParam String password,@RequestParam String emial){
        return loginService.register(userNme,password,emial);
    }
    @RequestMapping("img")
    public User img(@RequestParam String userName){
        return loginService.img(userName);
    }
}
