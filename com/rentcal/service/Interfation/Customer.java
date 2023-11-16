package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface Customer {
    public User cusLogin() throws SQLException;

    public User cusRegistered() throws SQLException;

    public void cusShowVehicle() throws SQLException;

    public void cusShowVehicleAsc() throws SQLException;

    public void cusShowVehicleDesc() throws SQLException;

    public void cusLease(User user) throws SQLException;

    public void cusRepaid(User user) throws SQLException;

    public void cusShowUserOrder(User user) throws SQLException;

    public User cusRecharge(User user) throws SQLException;
}
