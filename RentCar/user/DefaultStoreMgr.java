package RentCar.user;

import java.util.ArrayList;

import RentCar.Factory;
import RentCar.vehicle.Vehicle;

public class DefaultStoreMgr extends User implements StoreMgr {
    public DefaultStoreMgr() {
    }

    public DefaultStoreMgr(String userID, String userName, String userPwd) {
        super(userID, userName, userPwd);
    }

    @Override
    public boolean modifyCarInformation(ArrayList<Vehicle> list) {
        System.out.println("请输入修改车的车牌号");
        String vehicleId = sc.next();
        System.out.println("请输入修改后租金");
        int newPerRent = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVehicleId().equals(vehicleId)) {
                list.get(i).setPerRent(newPerRent);
            }
        }
        System.out.println("修改成功");
        return true;
    }

    @Override
    public boolean addNewCars(ArrayList<Vehicle> list) {
        System.out.println("请输入增加车的类型:");
        String type = sc.next();
        Vehicle v = Factory.getVehicle(type);
        list.add(v);
        System.out.println("增加成功");
        return true;
    }

    @Override
    public boolean deleteCar(ArrayList<Vehicle> list) {
        System.out.println("请输入删除车的车牌号");
        String vehicleId = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVehicleId().equals(vehicleId)) {
                list.remove(i);
            }
        }
        System.out.println("删除成功");
        return true;
    }

    public void viewCarInformation(ArrayList<Vehicle> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
