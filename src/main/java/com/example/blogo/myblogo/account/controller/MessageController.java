package com.example.blogo.myblogo.account.controller;

import com.example.blogo.myblogo.account.service.MessageService;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 修改保存用户信息
     * @param id
     * @param img
     * @param userName
     * @param password
     * @param age
     * @param email
     * @param phoneNumber
     * @param gender
     * @param IDCard
     * @param bankCard
     * @param realName
     * @param address
     * @param status
     * @param passport
     * @return
     */
    @RequestMapping("save")
    public ResponseMessage saveMessage(
            @RequestParam Integer id,
            @RequestParam String img,
            @RequestParam String userName,
            @RequestParam String password,
            @RequestParam Integer age,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String gender,
            @RequestParam String IDCard,
            @RequestParam String bankCard,
            @RequestParam String realName,
            @RequestParam String address,
            @RequestParam String status,
            @RequestParam String passport
    ) {
        return messageService.saveMessage(id,
                img,
                userName,
                password,
                age,
                email,
                phoneNumber,
                gender,
                IDCard,
                bankCard,
                realName,
                address,
                status,
                passport);
    }
}
