package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.vehicle.Vehicle;
import com.rentcal.control.View;
import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.StoreAddVehicle;
import com.rentcal.util.VehicleFactory;

public class AddVehicle implements StoreAddVehicle {
    //添加车辆
    static Scanner sc = View.sc;
    @Override
    public boolean AddnewVehicle() throws SQLException {
        System.out.println("请输入新增车的类型:");
        String type = sc.next();
        Vehicle newVehicle = VehicleFactory.vehicleFactory(type);
        System.out.println("车辆添加成功");
        return Vehicletb.addNewVehicles(newVehicle);
    }

    public static AddVehicle getAddVehicle() {
        return new AddVehicle();
    }
}
