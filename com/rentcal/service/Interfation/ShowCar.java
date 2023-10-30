package com.rentcal.service.Interfation;

import java.sql.SQLException;

public interface ShowCar {
    public void showVehicle() throws SQLException;

    public void showVehicleAsc() throws SQLException;

    public void showVehicleDesc() throws SQLException;
}
