package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserLogin {
    //用户登录接口
    public User login()throws SQLException;
}
