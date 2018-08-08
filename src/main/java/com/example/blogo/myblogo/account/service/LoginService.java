package com.example.blogo.myblogo.account.service;

import com.example.blogo.myblogo.account.dao.LoginDao;
import com.example.blogo.myblogo.account.domain.User;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import com.example.blogo.myblogo.account.views.TotalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public TotalUser login(String userNme, String password, String checkCode) {
        if (checkCode.equals("123")) {
            return login(userNme, password);
        } else {
            TotalUser totalUser = new TotalUser();
            totalUser.setMessage("查询失败");
            return totalUser;
        }
    }

    public TotalUser login(String userNme, String password) {
        try {
            User user = loginDao.findAllByNameAndPassword(userNme, password);
            user.setPassword("");
            user.setIDCard("");
            user.setBankCard("");
            user.setPassport("");
            TotalUser totalUser = new TotalUser();
            totalUser.setFlag(true);
            totalUser.setMessage("查询成功");
            totalUser.setUser(user);
            return totalUser;
        } catch (Exception e) {
            System.out.println(e);
            TotalUser totalUser = new TotalUser();
            totalUser.setMessage("查询失败");
            return totalUser;
        }
    }

    public ResponseMessage register(String userNme, String password, String emial) {
        User user = new User();
        user.setName(userNme);
        user.setPassword(password);
        user.setEmail(emial);
        try {
            if (loginDao.save(user) != null) {
                return new ResponseMessage(true, "注册成功");
            } else {
                return new ResponseMessage(false, "注册失败");
            }
        } catch (Exception e) {
            return new ResponseMessage(false, "注册失败");
        }
    }

}