package org.rental.service;

import java.util.Scanner;

import org.rental.account.RegularUsers;
import org.rental.account.RootUsers;
import org.rental.account.Users;
import org.rental.mysqlutil.JDBCUtils;
import org.rental.test.Text;

public class Login{
    static final int USER_LOGS = 1;
    static final int ROOT_USER_LOGS = 2;
    public static Scanner sc = Text.sc;
    public static Users login() throws Exception {
        System.out.println("登录或注册");
        System.out.println("按1进行普通用户登录");
        System.out.println("按2进行管理员登录");
        System.out.println("按其他键进行新用户注册");
        
        int select = sc.nextInt();
        if (select == USER_LOGS) {
            System.out.println("请输入用户名");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("请输入密码");
            String password = sc.nextLine();
            RegularUsers user = new RegularUsers(name, password);
            if (JDBCUtils.inquireUser(user)) {
                System.out.println("用户登陆成功");
                return user;
            } else {
                System.out.println("用户登录失败");
                return null;
            }
        } else if (select == ROOT_USER_LOGS) {
            System.out.println("请输入root用户名");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("请输入root密码");
            String password = sc.nextLine();
            RootUsers user = new RootUsers(name, password);
            if (JDBCUtils.inquireUser(user)) {
                System.out.println("管理员登陆成功");
                return user;
            } else {
                System.out.println("管理员登录失败");
                return null;
            }
        }
        else {
            return register();
        }
    }
    public static RegularUsers register() throws Exception {
        RegularUsers u = new RegularUsers();
        System.out.println("输入注册姓名");
        sc.nextLine();
        u.setUserName(sc.nextLine());
        System.out.println("输入注册密码");
        u.setUserPassword(sc.nextLine());
        if (JDBCUtils.inquireUser(u)) {
            System.out.println("该用户已存在");
            return null;
        }
        System.out.println("请完善个人信息");
        System.out.println("输入住址");
        u.setAddress(sc.nextLine());
        System.out.println("输入电话");
        u.setContactNumber(sc.nextLine());
        if (JDBCUtils.increaseUsers(u)) {
            System.out.println("注册成功,已进行登录");
            return u;
        }
        return null;
    }
}
