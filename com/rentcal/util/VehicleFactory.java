package com.rentcal.util;

import java.util.Scanner;

import com.rentcal.bean.vehicle.Bus;
import com.rentcal.bean.vehicle.Car;
import com.rentcal.bean.vehicle.Trunk;
import com.rentcal.bean.vehicle.Vehicle;
import com.rentcal.control.View;

public class VehicleFactory {
    static Scanner sc = View.sc;

    public static Vehicle factory(String type) {
        switch (type) {
            case "轿车":
                Car newCar = new Car();
                return newCar;
            case "客车":
                Bus newBus = new Bus();
                return newBus;
            case "货车":
                Trunk newTrunk = new Trunk();
                return newTrunk;
            default:
                break;
        }
        return null;
    }

    public static Vehicle vehicleFactory(String type) {
        System.out.println("请输入新增车的品牌:");
        String brand = sc.next();
        System.out.println("请输入新增车的日租金:");
        int perrent = sc.nextInt();
        System.out.println("请输入新增车的车牌:");
        String number = sc.next();
        switch (type) {
            case "轿车":
                System.out.println("请输入轿车的型号:");
                String model = sc.next();
                Car newCar = new Car(number, brand, type, perrent, model);
                return newCar;
            case "客车":
                System.out.println("请输入客车的载客量:");
                String passengerCapacit = sc.next();
                Bus newBus = new Bus(number, brand, type, perrent, passengerCapacit);
                return newBus;
            case "货车":
                System.out.println("请输入货车的载重量:");
                String cargoCapacity = sc.next();
                Trunk newTrunk = new Trunk(number, brand, type, perrent, cargoCapacity);
                return newTrunk;
            default:
                break;
        }
        return null;
    }
}
