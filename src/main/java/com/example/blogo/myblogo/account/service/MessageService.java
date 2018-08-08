package com.example.blogo.myblogo.account.service;

import com.example.blogo.myblogo.account.dao.LoginDao;
import com.example.blogo.myblogo.account.dao.MessageDao;
import com.example.blogo.myblogo.account.domain.User;
import com.example.blogo.myblogo.account.views.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private LoginDao loginDao;

    public ResponseMessage saveMessage(Integer id,
                                       String img,
                                       String userName,
                                       String password,
                                       Integer age,
                                       String email,
                                       String phoneNumber,
                                       String gender,
                                       String IDCard,
                                       String bankCard,
                                       String realName,
                                       String address,
                                       String status,
                                       String passport) {
        try {
            User user = loginDao.findById(id).get();
            user.setHistoryImg(img == null ? user.getImg() : img);
            user.setName(userName == null ? user.getName() : userName);
            user.setPassword(password == null ? user.getPassword() : password);
            user.setAge(age == null ? user.getAge() : age);
            user.setEmail(email == null ? user.getEmail() : email);
            user.setPhoneNumber(phoneNumber == null ? user.getPhoneNumber() : phoneNumber);
            user.setGender(gender == null ? user.getGender() : gender);
            user.setIDCard(IDCard == null ? user.getIDCard() : IDCard);
            user.setBankCard(bankCard == null ? user.getBankCard() : bankCard);
            user.setRealName(realName == null ? user.getRealName() : realName);
            user.setAddress(address == null ? user.getAddress() : address);
            user.setStatus(status == null ? user.getStatus() : status);
            user.setPassport(passport == null ? user.getPassport() : passport);
            try {
                User save = messageDao.save(user);
                if (save == null) {
                    return new ResponseMessage(false, "修改信息失败");
                } else {
                    return new ResponseMessage(false, "修改信息成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMessage(false, "修改信息失败");
            }
        } catch (Exception e) {
            return new ResponseMessage(false, "修改信息失败");
        }


    }
}
