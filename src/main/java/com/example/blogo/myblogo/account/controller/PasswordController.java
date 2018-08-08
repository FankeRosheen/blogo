package com.example.blogo.myblogo.account.controller;

import com.example.blogo.myblogo.account.service.PasswordService;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("password")
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    /**
     * 修改密码
     * @param userName
     * @param password
     * @param newPassword
     * @return
     */
    @RequestMapping("change")
    public ResponseMessage changePassword(@RequestParam String userName, @RequestParam String password, @RequestParam String newPassword) {
        return passwordService.changePassword(userName, password, newPassword);
    }

    /**
     * 忘记密码发送验证码
     * @param userName
     * @param email
     * @param httpSession
     * @return
     */
    @RequestMapping("forgot")
    public ResponseMessage forgotPassword(@RequestParam String userName, @RequestParam String email, @RequestParam HttpSession httpSession){
        return passwordService.forgotPassword(userName,email,httpSession);
    }

    /**
     * 根据验证码修改用户密码
     * @param userName
     * @param code
     * @param password
     * @param httpSession
     * @return
     */
    @RequestMapping("forgotChange")
    public ResponseMessage forgotChange(@RequestParam String userName,@RequestParam String code,@RequestParam String password,@RequestParam HttpSession httpSession){
        return passwordService.forgotChange(userName,code,password,httpSession);
    }
}
