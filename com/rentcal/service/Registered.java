package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.user.DefaultCustomer;
import com.rentcal.bean.user.User;
import com.rentcal.control.View;
import com.rentcal.dao.Usertb;
import com.rentcal.service.Interfation.UserRegistered;

public class Registered implements UserRegistered {
    @Override
    public DefaultCustomer registered() throws SQLException {
        Scanner sc = View.sc;
        DefaultCustomer newUser = null;
        while (newUser == null) {
            System.out.println("请输入注册用户名:");
            String name = sc.next();
            System.out.println("请输入注册密码:");
            String pwd = sc.next();
            if (Usertb.seekUser(new User(name, pwd)) != null) {
                System.out.println("该用户以存在");
            } else {
                newUser = new DefaultCustomer(name, pwd);
                System.out.println("请完善个人信息");
                System.out.println("请输入住址:");
                newUser.setAddress(sc.next());
                System.out.println("请输入电话:");
                newUser.setPhone(sc.next());
                if (Usertb.addUser(newUser)) {
                    System.out.println("新用户注册成功,已自动登录");
                    return newUser;
                }
            }
        }
        return newUser;
    }

    public static Registered getRegistered() {
        return new Registered();
    }
}
