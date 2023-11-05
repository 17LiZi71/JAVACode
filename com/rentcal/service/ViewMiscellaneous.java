package com.rentcal.service;

import java.sql.SQLException;

import com.rentcal.bean.user.User;
import com.rentcal.dao.Business;
import com.rentcal.dao.Usertb;
import com.rentcal.service.Interfation.ViewSundry;

public class ViewMiscellaneous implements ViewSundry {
    @Override
    public void showUserOrder(User user) throws SQLException {
        System.out.println("查看订单");
        Usertb.showLease(user);
    }

    @Override
    public void showMoney() throws SQLException {
        System.out.println("共营收" + Business.showTurnover() + "元");
    }
    @Override
    public void viewUser() throws SQLException {
        System.out.println("用户信息展示");
        Usertb.userInformation();
    }

    public static ViewMiscellaneous getMiscellaneous() {
        return new ViewMiscellaneous();
    }
}