package com.rentcal.bean.user;

public class DefaultCustomer extends User {
    private String Address;
    private String Phone;
    //普通用户类，继承自User，同时有独有的成员变量，住址和电话
    public DefaultCustomer(String userName, String userPwd) {
        super(userName, userPwd);
    }
    //定义构造方法，定义get set方法
    public DefaultCustomer(String userName, String userPwd, int userID) {
        super(userName, userPwd, userID);
    }

    public DefaultCustomer() {
    }

    public DefaultCustomer(int userID, String userName, String userPwd, String address, String phone) {
        super(userID, userName, userPwd);
        Address = address;
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

}
