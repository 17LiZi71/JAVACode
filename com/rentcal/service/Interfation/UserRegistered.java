package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.DefaultCustomer;

public interface UserRegistered {
    public DefaultCustomer registered() throws SQLException;
}
