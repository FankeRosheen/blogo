package com.example.blogo.myblogo.account.service;

import com.example.blogo.myblogo.account.dao.LoginDao;
import com.example.blogo.myblogo.account.dao.PasswordDao;
import com.example.blogo.myblogo.account.domain.User;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
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
            if (user.getHistoryPassword() == null) {
                user.setHistoryPassword(user.getHistoryPassword() + user.getPassword());
                user.setPassword(newPassword);
                User save = passwordDao.save(user);
                if (save != null) {
                    return new ResponseMessage(false, "修改密码成功");
                } else {
                    return new ResponseMessage(false, "修改密码失败");
                }
            }
            if (user.getHistoryPassword().contains(newPassword) || user.getPassword().equals(newPassword)) {
                return new ResponseMessage(false, "修改密码失败,密码不能为以前用过的密码");
            } else {
                user.setHistoryPassword(user.getHistoryPassword() + user.getPassword());
                user.setPassword(newPassword);
                User save = passwordDao.save(user);
                if (save != null) {
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

    public ResponseMessage forgotPassword(String userName, String email, Cookie cookie) {
        try {
            User user = passwordDao.findByNameAndEmail(userName, email);
            if (user == null) {
                return new ResponseMessage(false, "邮箱或用户名输入错误");
            } else {
                String uuid = UUID.randomUUID().toString();
                cookie.setValue(uuid);
                System.out.println(uuid);
                System.out.println(cookie.getValue());
                return new ResponseMessage(true, "请查看邮箱,接收验证码");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "系统异常");
        }
    }

    public ResponseMessage forgotChange(String userName, String code, String password, Cookie cookie) {
        if (code == null || cookie.getValue() == null) {
            return new ResponseMessage(false, "修改密码失败,验证码不正确");
        }
        if (!code.equals(cookie.getValue())) {
            return new ResponseMessage(false, "验证码错误");
        } else {
            try {
                User user = loginDao.findAllByName(userName);
                if (user.getHistoryPassword() == null) {
                    user.setHistoryPassword(user.getHistoryPassword() + user.getPassword());
                    user.setPassword(password);
                    return changePasswordByCheckCode(user);
                }
                if (user.getPassword().contains(password) || user.getPassword().equals(password)) {
                    return new ResponseMessage(false, "修改密码失败,密码不能为以前用过的密码");
                } else {
                    user.setHistoryPassword(user.getHistoryPassword() + user.getPassword());
                    user.setPassword(password);
                    return changePasswordByCheckCode(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMessage(false, "修改密码失败");
            }
        }
    }

    private ResponseMessage changePasswordByCheckCode(User user) {
        try {
            User save = passwordDao.save(user);
            if (save != null) {
                return new ResponseMessage(false, "修改密码成功");
            } else {
                return new ResponseMessage(false, "修改密码失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "修改密码失败");
        }
    }
}
