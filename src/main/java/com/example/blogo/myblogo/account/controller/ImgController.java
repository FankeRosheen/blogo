package com.example.blogo.myblogo.account.controller;

import com.example.blogo.myblogo.account.service.ImgService;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * img Controller
 */
@RestController
@RequestMapping("img")
public class ImgController {
    @Autowired
    private ImgService imgService;
    /**
     * 用户图像查询
     * @param userName
     * @return
     */
    @RequestMapping("findImg")
    public String img(@RequestParam String userName){
        return imgService.img(userName);
    }

    /**
     * 改变用户图像
     * @param userName
     * @param img
     * @return
     */
    @RequestMapping("changeImg")
    public ResponseMessage changeImg(@RequestParam String userName,@RequestParam String img){
        return imgService.changeImg(userName,img);
    }
}
