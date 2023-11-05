package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface ViewSundry {
    public void showUserOrder(User user) throws SQLException;

    public void showMoney() throws SQLException;

    public void viewUser() throws SQLException;
}
