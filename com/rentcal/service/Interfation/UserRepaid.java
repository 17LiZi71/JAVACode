package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserRepaid {
    public void repaid(User user) throws SQLException;
}
