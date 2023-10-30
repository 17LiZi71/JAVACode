package com.rentcal.bean.user;

public class User {
    private int userID;
    private String userName;
    private String userPwd;
    private String permissions;

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

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
