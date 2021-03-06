package com.example.blogo.myblogo.account.service;

import com.example.blogo.myblogo.account.dao.ImgDao;
import com.example.blogo.myblogo.account.domain.User;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgService {
    @Autowired
    private ImgDao imgDao;

    public String img(String userName) {
        User user = imgDao.findAllByName(userName);
        return user.getImg() == null ? "沒有照片" : user.getImg();
    }

    public ResponseMessage changeImg(String userName, String img) {
        try {
            User user = imgDao.findAllByName(userName);
            if (img.equals(user.getImg())) {
                return new ResponseMessage(false, "修改图片成功");
            }
            user.setHistoryImg(user.getHistoryImg() + user.getImg());
            user.setImg(img);
            imgDao.save(user);
            return new ResponseMessage(false, "修改图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(false, "修改图片失败");
        }
    }
}
