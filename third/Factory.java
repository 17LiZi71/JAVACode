package third;

import java.util.Scanner;

import third.vehicle.Bus;
import third.vehicle.Car;
import third.vehicle.Trunk;
import third.vehicle.Vehicle;

public class Factory {
    public static Scanner sc = RentMgr.sc;

    public static Vehicle getVehicle(String type) {
        if (type.equals("轿车")) {
            Car c = new Car();
            c.setType("轿车");
            System.out.println("请输入轿车型号");
            c.setModel(sc.next());
            System.out.println("请输入增加车的品牌");
            c.setBrand(sc.next());
            System.out.println("请输入日租金");
            c.setPerRent(sc.nextInt());
            System.out.println("请输入轿车车牌号");
            c.setVehicleId(sc.next());
            return c;
        }
        if (type.equals("客车")) {
            Bus c = new Bus();
            c.setType("客车");
            System.out.println("请输入客车载客量");
            c.setPassengerCapacity(sc.nextInt());
            System.out.println("请输入增加车的品牌");
            c.setBrand(sc.next());
            System.out.println("请输入日租金");
            c.setPerRent(sc.nextInt());
            System.out.println("请输入客车车牌号");
            c.setVehicleId(sc.next());
            return c;
        }
        if (type.equals("货车")) {
            Trunk c = new Trunk();
            c.setType("货车");
            System.out.println("请输入货车载货量");
            c.setCargoCapacity(sc.nextInt());
            System.out.println("请输入增加车的品牌");
            c.setBrand(sc.next());
            System.out.println("请输入日租金");
            c.setPerRent(sc.nextInt());
            System.out.println("请输入货车车牌号");
            c.setVehicleId(sc.next());
            return c;
        }
        return null;
    }
}