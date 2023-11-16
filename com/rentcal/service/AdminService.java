package com.rentcal.service;

import java.sql.SQLException;

import com.rentcal.service.Interfation.Admin;

public class AdminService implements Admin {
    @Override
    public void admViewUser() throws SQLException {
        ViewMiscellaneous.getMiscellaneous().viewUser();
    }

    @Override
    public void admDeleteUser() throws SQLException {
        Delete.getDeleteVehicle().deleteUser();
    }

    @Override
    public void admAddnewVehicle() throws SQLException {
        AddVehicle.getAddVehicle().AddnewVehicle();
    }

    @Override
    public void admDeleteVehicle() throws SQLException {
        Delete.getDeleteVehicle().deleteVehicle();
    }

    @Override
    public void admModifyVehiclePrice() throws SQLException {
        ModifyVehicle.getModifyVehicle().modifyVehiclePrice();
    }

    @Override
    public void admOdifyVehicleNumber() throws SQLException {
        ModifyVehicle.getModifyVehicle().modifyVehicleNumber();
    }

    @Override
    public void admShowVehicle() throws SQLException {
        ShowVehicles.getShowVehicles().showVehicle();
    }

    @Override
    public void admShowMoney() throws SQLException {
        ViewMiscellaneous.getMiscellaneous().showMoney();
    }

    public static AdminService getAdminService() {
        return new AdminService();
    }
}
