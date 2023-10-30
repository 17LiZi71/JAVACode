package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.vehicle.Vehicle;
import com.rentcal.control.View;
import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.StoreAddVehicle;

public class AddVehicle implements StoreAddVehicle{
    static Scanner sc = View.sc;
    @Override
    public boolean AddnewVehicle() throws SQLException {
        System.out.println("请输入新增车的类型:");
        String type = sc.next();
        System.out.println("请输入新增车的品牌:");
        String brand = sc.next();
        System.out.println("请输入新增车的日租金:");
        int perrent = sc.nextInt();
        System.out.println("请输入新增车的车牌:");
        String number = sc.next();
        System.out.println("请输入新增车的型号:");
        String model = sc.next();
        Vehicle newVehicle = new Vehicle(number, brand, type, perrent);
        if (Vehicletb.findVehicle(newVehicle, model) != -1) {
            System.out.println("该车已经存在");
            return false;
        }
        System.out.println("车辆添加成功");
        return Vehicletb.addNewVehicles(newVehicle, model);
    }

    public static AddVehicle getAddVehicle() {
        return new AddVehicle();
    }
}
