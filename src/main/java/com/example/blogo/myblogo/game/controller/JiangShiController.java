package com.example.blogo.myblogo.game.controller;

import com.example.blogo.myblogo.game.domain.Game;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jiangShi")
public class JiangShiController {
    public Game findGameInformation(@RequestParam String gameName,@RequestParam Integer currentUserId){
        return null;
    }
}
