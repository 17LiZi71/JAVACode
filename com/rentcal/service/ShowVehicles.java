package com.rentcal.service;

import java.sql.SQLException;

import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.ShowCar;

public class ShowVehicles implements ShowCar {
    @Override
    public void showVehicle() throws SQLException {
        System.out.println("展示所有车辆");
        Vehicletb.showVehicle();
    }

    @Override
    public void showVehicleAsc() throws SQLException {
        System.out.println("车辆按价格升序");
        Vehicletb.showCarAsc();
    }

    @Override
    public void showVehicleDesc() throws SQLException {
        System.out.println("车辆按价格降序");
        Vehicletb.showCarDesc();
    }

    public static ShowVehicles getShowVehicles() {
        return new ShowVehicles();
    }
}
