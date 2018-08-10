package com.example.blogo.myblogo.account.controller;

import com.example.blogo.myblogo.account.service.LoginService;
import com.example.blogo.myblogo.account.views.ResponseMessage;
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

    /**
     * 有验证码的登录
     * @param userName
     * @param password
     * @param checkCode
     * @return TotalUser
     */
    @RequestMapping("loginWithCode")
    public TotalUser login(@RequestParam String userName, @RequestParam String password, @RequestParam String checkCode){
        return loginService.login(userName,password,checkCode);
    }

    /**
     * 有验证码的登录
     * @param userName
     * @param password
     * @return TotalUser
     */
    @RequestMapping("login")
    public TotalUser login(@RequestParam String userName,@RequestParam String password){
       return loginService.login(userName,password);
    }

    /**
     * 注册用户
     * @param userName
     * @param password
     * @param emial
     * @return ResponseMessage
     */
    @RequestMapping("register")
    public ResponseMessage register(@RequestParam String userName, @RequestParam String password, @RequestParam String emial){
        return loginService.register(userName,password,emial);
    }
    /**
     * 检查用户名可用性
     * @param userName
     * @return ResponseMessage
     */
    @RequestMapping("checkUserName")
    public ResponseMessage checkUserName(@RequestParam String userName){
        return loginService.checkUserName(userName);
    }

}
