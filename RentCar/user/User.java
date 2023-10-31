package RentCar.user;

import java.util.Scanner;

import RentCar.RentMgr;

public abstract class User {
    private String UserID;
    private String UserName;
    private String UserPwd;
    static Scanner sc = RentMgr.sc;

    public static User logOn() {
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        if (name.equals("admin") && password.equals("admin")) {
            System.out.println("管理员登录成功!");
            DefaultStoreMgr storeMgr = new DefaultStoreMgr("1", "admin", "admin");
            return storeMgr;
        } else if (name.equals("张三") && password.equals("1234567")) {
            System.out.println("顾客登录成功！");
            DefaultCustomer customer = new DefaultCustomer("2", "张三", "1234567");
            return customer;
        }
        System.out.println("登录失败，请重新登录");
        return null;
    }

    public User() {
    }

    public User(String userID, String userName, String userPwd) {
        UserID = userID;
        UserName = userName;
        UserPwd = userPwd;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }

}
