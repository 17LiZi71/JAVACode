package com.rentcal.bean.user;

public class VipCustomer extends User {
    public VipCustomer() {
    }

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
