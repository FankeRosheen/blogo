package com.example.blogo.myblogo.account.service;

import com.example.blogo.myblogo.account.dao.LoginDao;
import com.example.blogo.myblogo.account.domain.User;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import com.example.blogo.myblogo.account.views.TotalUser;
import org.apache.logging.log4j.message.ReusableMessage;
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
            ResponseMessage check = check(userNme, password, emial);
            if (check.getMessage() == "用户名已被使用"){
                return check;
            }
            if (loginDao.save(user) != null) {
                return new ResponseMessage(true, "注册成功");
            } else {
                return new ResponseMessage(false, "注册失败");
            }
        } catch (Exception e) {
            return new ResponseMessage(false, "注册失败");
        }
    }

<<<<<<< HEAD
    public ResponseMessage check(String userName, String password, String emial) {
        if (userName == "" || userName == null){
            return new ResponseMessage(true,"请输入用户名");
        }else {
            User user = loginDao.findByName(userName);
            if (user == null){
                return new ResponseMessage(true,"用户名可用");
            }else {
                return new ResponseMessage(true,"用户名已被使用");
            }
        }
=======
    public ResponseMessage checkUserName(String userName) {
        if (loginDao.findAllByName(userName) != null){
            return new ResponseMessage(false,"用户名已被使用");
        }else {
            return new ResponseMessage(true,"用户名可用");
        }

>>>>>>> 4e08d0551610ccfad2aeab111df76fcd46b504fa
    }
}
