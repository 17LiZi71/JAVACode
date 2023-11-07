package com.rentcal.bean.user;

public abstract class User {//抽象类User，所有用户的父类
    private int userID;
    private String userName;
    private String userPwd;
    private String permissions;
    //定义共有成员变量，包括用户id，用户账号，用户密码，用户权限
    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }
    //提供有参和无参构造方法，定义公共setget方法
    public User(String userName, String userPwd, int userID) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userID = userID;
    }

    public User(int userID) {
        this.userID = userID;
    }

    public User() {

    }

    public User(int userID, String userName, String userPwd) {
        this.userID = userID;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

}
