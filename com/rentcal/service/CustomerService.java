package com.rentcal.service;

import java.sql.SQLException;

import com.rentcal.bean.user.User;
import com.rentcal.service.Interfation.Customer;

public class CustomerService implements Customer {
    @Override
    public User cusLogin() throws SQLException {
        return Login.getLogin().login();
    }

    @Override
    public User cusRegistered() throws SQLException {
        return Registered.getRegistered().registered();
    }

    @Override
    public void cusShowVehicle() throws SQLException {
        ShowVehicles.getShowVehicles().showVehicle();
    }

    @Override
    public void cusShowVehicleAsc() throws SQLException {
        ShowVehicles.getShowVehicles().showVehicleAsc();
    }

    @Override
    public void cusShowVehicleDesc() throws SQLException {
        ShowVehicles.getShowVehicles().showVehicleDesc();
    }

    @Override
    public void cusLease(User user) throws SQLException {
        Lease.getLease().lease(user);
    }

    @Override
    public void cusRepaid(User user) throws SQLException {
        Repaid.getRepaid().repaid(user);
    }

    @Override
    public void cusShowUserOrder(User user) throws SQLException {
        ViewMiscellaneous.getMiscellaneous().showUserOrder(user);
    }

    @Override
    public User cusRecharge(User user) throws SQLException {
        return Recharge.getRecharge().recharge(user);
    }

    public static CustomerService getCustomerService() {
        return new CustomerService();
    }
}
