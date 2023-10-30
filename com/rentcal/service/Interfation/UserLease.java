package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserLease {
    public boolean lease(User user) throws SQLException;
}
