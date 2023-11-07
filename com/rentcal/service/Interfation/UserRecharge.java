package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserRecharge {
    //用户充值vip接口
    public User recharge(User user) throws SQLException;
}
