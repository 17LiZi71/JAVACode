package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.vehicle.Vehicle;
import com.rentcal.control.View;
import com.rentcal.dao.Usertb;
import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.StoreDeleteVe;
import com.rentcal.util.VehicleFactory;

public class Delete implements StoreDeleteVe {
    static Scanner sc = View.sc;

    @Override
    public boolean deleteVehicle() throws SQLException {
        System.out.println("请输入删除车的类型:");
        String type = sc.next();
        System.out.println("请输入删除车的品牌:");
        String brand = sc.next();
        System.out.println("请输入删除车的型号:");
        String model = sc.next();
        Vehicle oldVehicle = VehicleFactory.factory(type);
        oldVehicle.setType(type);
        oldVehicle.setBrand(brand);
        if (Vehicletb.findVehicle(oldVehicle, model) == -1) {
            System.out.println("该车不存在");
            return false;
        }
        System.out.println("车辆删除成功");
        return Vehicletb.deleteVehicle(Vehicletb.findVehicle(oldVehicle, model));
    }

    @Override
    public boolean deleteUser() throws SQLException {
        System.out.println("请输入要删除的用户ID");
        int userID = sc.nextInt();
        Usertb.deleteUser(userID);
        System.out.println("删除用户成功");
        return true;
    }

    public static Delete getDeleteVehicle() {
        return new Delete();
    }
}
