package com.rentcal.service.Interfation;

import java.sql.SQLException;

public interface Admin {
    public void admViewUser() throws SQLException;

    public void admDeleteUser() throws SQLException;

    public void admAddnewVehicle() throws SQLException;

    public void admDeleteVehicle() throws SQLException;

    public void admModifyVehiclePrice() throws SQLException;

    public void admOdifyVehicleNumber() throws SQLException;

    public void admShowVehicle() throws SQLException;

    public void admShowMoney() throws SQLException;
}
