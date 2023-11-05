package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.control.View;
import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.ModifyVeInmtion;

public class ModifyVehicle implements ModifyVeInmtion{
    static Scanner sc = View.sc;
    @Override
    // 修改租金
    public boolean modifyVehiclePrice() throws SQLException {
        System.out.println("输入修改日租金的车辆编号");
        int vehicleId = sc.nextInt();
        System.out.println("输入修改后日租金");
        int price = sc.nextInt();
        System.out.println("车辆修改成功");
        return Vehicletb.modifyprice(vehicleId, price);
    }
    @Override
    public boolean modifyVehicleNumber() throws SQLException {
        System.out.println("输入要修改的车辆的编号");
        int vehicleId = sc.nextInt();
        System.out.println("输入修改后车牌号");
        String number = sc.next();
        System.out.println("车辆修改成功");
        return Vehicletb.modifyNumber(vehicleId, number);
    }

    public static ModifyVehicle getModifyVehicle() {
        return new ModifyVehicle();
    }
}
