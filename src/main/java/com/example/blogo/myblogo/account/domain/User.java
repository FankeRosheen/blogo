package com.example.blogo.myblogo.account.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "img")
    private String img;  //用户图像
    @Column(name = "name")
    private String name;  //用户名
    @Column(name = "password")
    private String password;  //密码
    @Column(name = "age")
    private Integer age;  //年龄
    @Column(name = "email")
    private String email;  //邮箱
    @Column(name = "phoneNumber")
    private String phoneNumber;  //手机号码
    @Column(name = "gender")
    private String gender;  //性别
    @Column(name = "IDCard")
    private String IDCard;  //身份证
    @Column(name = "bankCard")
    private String bankCard;  //银行卡
    @Column(name = "realName")
    private String realName;  //真实姓名
    @Column(name = "address")
    private String address;  //地址
    @Column(name = "status")
    private String status;  //状态
    @Column(name = "passport")
    private String passport;  //护照
    @Column(name = "history_img")
    private String historyImg;  //历史用户图像
    @Column(name = "history_password")
    private String historyPassword;  //历史密码

    public String getHistoryImg() {
        return historyImg;
    }

    public void setHistoryImg(String historyImg) {
        this.historyImg = historyImg;
    }


    public String getHistoryPassword() {
        return historyPassword;
    }


    public void setHistoryPassword(String historyPassword) {
        this.historyPassword = historyPassword;
    }


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", IDCard='" + IDCard + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", realName='" + realName + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }


}
