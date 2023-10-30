package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserRecharge {
    public User recharge(User user) throws SQLException;
}
