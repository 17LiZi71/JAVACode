package com.rentcal.bean.user;

public class VipCustomer extends User {
    //Vip用户类，继承自User
    public VipCustomer() {
    }
    //定义带参和无参构造方法
    public VipCustomer(String userName, String userPwd) {
        super(userName, userPwd);
    }

    public VipCustomer(String userName, String userPwd, int userID) {
        super(userName, userPwd, userID);
    }

    public VipCustomer(int userID, String userName, String userPwd) {
        super(userID, userName, userPwd);
    }

}
