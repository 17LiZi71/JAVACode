package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserRegistered {
    //用户注册接口
    public User registered() throws SQLException;
}
