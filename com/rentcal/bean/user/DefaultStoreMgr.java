package com.rentcal.bean.user;

public class DefaultStoreMgr extends User {
    public DefaultStoreMgr() {
    }

    public DefaultStoreMgr(String userName, String userPwd, int userID) {
        super(userName, userPwd, userID);
    }

    public DefaultStoreMgr(String userName, String userPwd) {
        super(userName, userPwd);
    }

}
