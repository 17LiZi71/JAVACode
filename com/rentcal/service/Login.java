package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.user.DefaultCustomer;
import com.rentcal.bean.user.DefaultStoreMgr;
import com.rentcal.bean.user.User;
import com.rentcal.bean.user.VipCustomer;
import com.rentcal.control.View;
import com.rentcal.dao.Usertb;
import com.rentcal.service.Interfation.UserLogin;

public class Login implements UserLogin{
    @Override
    public User login() throws SQLException {
        Scanner sc = View.sc;
        User user = null;
        while (user == null) {
            System.out.println("请输入用户名:");
            String name = sc.next();
            System.out.println("请输入密码:");
            String pwd = sc.next();
            user = Usertb.seekUser(new User(name, pwd));
            if (user instanceof VipCustomer) {
                System.out.println("vip用户登录成功");
                break;
            }
            if (user instanceof DefaultCustomer) {
                System.out.println("普通用户登录成功");
                break;
            }
            if (user instanceof DefaultStoreMgr) {
                System.out.println("管理员登录成功");
                break;
            }
            System.out.println("登录失败,请再次尝试");
        }
        return user;
    }

    public static Login getLogin() {
        return new Login();
    }
}
