package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.DefaultCustomer;

public interface UserRegistered {
    //用户注册接口
    public DefaultCustomer registered() throws SQLException;
}
