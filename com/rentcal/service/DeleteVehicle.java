package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.vehicle.Vehicle;
import com.rentcal.control.View;
import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.StoreDeleteVe;

public class DeleteVehicle implements StoreDeleteVe{
    static Scanner sc = View.sc;

    @Override
    public boolean deleteVehicle() throws SQLException {
        System.out.println("请输入删除车的类型:");
        String type = sc.next();
        System.out.println("请输入删除车的品牌:");
        String brand = sc.next();
        System.out.println("请输入删除车的型号:");
        String model = sc.next();
        Vehicle oldVehicle = new Vehicle();
        oldVehicle.setType(type);
        oldVehicle.setBrand(brand);
        if (Vehicletb.findVehicle(oldVehicle, model) == -1) {
            System.out.println("该车不存在");
            return false;
        }
        System.out.println("车辆删除成功");
        return Vehicletb.deleteVehicle(Vehicletb.findVehicle(oldVehicle, model));
    }

    public static DeleteVehicle getDeleteVehicle() {
        return new DeleteVehicle();
    }
}
