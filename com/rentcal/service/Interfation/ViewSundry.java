package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface ViewSundry {
    //展示用户订单及营业额接口
    public void showUserOrder(User user) throws SQLException;

    public void showMoney() throws SQLException;

    public void viewUser() throws SQLException;
}
