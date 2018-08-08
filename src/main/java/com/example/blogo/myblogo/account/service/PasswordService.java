package com.example.blogo.myblogo.account.service;

import com.example.blogo.myblogo.account.dao.LoginDao;
import com.example.blogo.myblogo.account.dao.PasswordDao;
import com.example.blogo.myblogo.account.domain.User;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class PasswordService {
    @Autowired
    private PasswordDao passwordDao;
    @Autowired
    private LoginDao loginDao;

    public ResponseMessage changePassword(String userName, String password, String newPassword) {
        try {
            User user = loginDao.findAllByNameAndPassword(userName, password);
            if (user.getHistoryPassword().contains(password) || user.getPassword().equals(password)) {
                return new ResponseMessage(false, "修改密码失败,密码不能为以前用过的密码");
            } else {
                user.setHistoryPassword(user.getHistoryPassword() + user.getPassword());
                user.setPassword(newPassword);
                User save = passwordDao.save(user);
                if (save == null) {
                    return new ResponseMessage(false, "修改密码成功");
                } else {
                    return new ResponseMessage(false, "修改密码失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "修改密码失败");
        }
    }

    public ResponseMessage forgotPassword(String userName, String email, HttpSession httpSession) {
        try {
            User user = passwordDao.findByNameAndEmail(userName, email);
            if (user == null) {
                return new ResponseMessage(false, "邮箱或用户名输入错误");
            } else {
                UUID uuid = UUID.randomUUID();
                httpSession.setAttribute(userName, uuid);
                System.out.println(uuid);
                return new ResponseMessage(true, "请查看邮箱,接收验证码");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "系统异常");
        }
    }

    public ResponseMessage forgotChange(String userName, String code, String password, HttpSession httpSession) {
        if (code == httpSession.getAttribute(userName)) {
            return new ResponseMessage(false, "验证码错误");
        } else {
            try {
                User user = loginDao.findAllByName(userName);
                if (user.getPassword().contains(password) || user.getPassword().equals(password)) {
                    return new ResponseMessage(false, "修改密码失败,密码不能为以前用过的密码");
                } else {
                    user.setHistoryPassword(user.getHistoryPassword() + user.getPassword());
                    user.setPassword(password);
                    try {
                        User save = passwordDao.save(user);
                        if (save == null) {
                            return new ResponseMessage(false, "修改密码成功");
                        } else {
                            return new ResponseMessage(false, "修改密码失败");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseMessage(false, "修改密码失败");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMessage(false, "修改密码失败");
            }
        }
    }
}
