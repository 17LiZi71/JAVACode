package com.rentcal.bean.user;

public class DefaultStoreMgr extends User {
    public DefaultStoreMgr() {
    }
    //管理员类，继承自User类，定义带参与无参构造
    public DefaultStoreMgr(String userName, String userPwd, int userID) {
        super(userName, userPwd, userID);
    }

    public DefaultStoreMgr(String userName, String userPwd) {
        super(userName, userPwd);
    }

}
