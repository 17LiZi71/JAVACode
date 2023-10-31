package RentCar.user;

import java.util.ArrayList;
import java.util.Scanner;

import RentCar.RentMgr;
import RentCar.vehicle.Bus;
import RentCar.vehicle.Car;
import RentCar.vehicle.Trunk;
import RentCar.vehicle.Vehicle;

public class DefaultCustomer extends User implements Customer {
    Scanner sc = RentMgr.sc;

    public DefaultCustomer() {
    }

    public DefaultCustomer(String userID, String userName, String userPwd) {
        super(userID, userName, userPwd);
    }

    @Override
    public void viewCarInformation(ArrayList<Vehicle> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Override
    public boolean rentalCar(ArrayList<Vehicle> list) {
        System.out.println("1.轿车  2.客车  3.货车");
        System.out.println("请选择你要租赁的汽车类型");
        int chose = sc.nextInt();
        if (chose == 1) {
            ArrayList<Vehicle> list1 = ridRepeat1(list, 1, "轿车");
            ArrayList<String> strlist = show(list1);
            System.out.println("\n请选择你要租赁的轿车品牌:");
            ArrayList<Vehicle> list2 = ridRepeat1(list1, 2, strlist.get(sc.nextInt() - 1));
            int count = 1;
            for (int i = 0; i < list2.size(); i++) {
                Car c = (Car) list2.get(i);
                System.out.print(count + "." + c.getModel() + "  ");
                count++;
            }
            System.out.println("\n请选择你要租赁的轿车型号:");
            Car c = (Car) list2.get(sc.nextInt() - 1);
            c.leaseOutFlow();
        } else if (chose == 2) {
            ArrayList<Vehicle> list1 = ridRepeat1(list, 1, "客车");
            ArrayList<String> strlist = show(list1);
            System.out.println("\n请选择你要租赁的客车品牌:");
            ArrayList<Vehicle> list2 = ridRepeat1(list1, 2, strlist.get(sc.nextInt() - 1));
            int count = 1;
            for (int i = 0; i < list2.size(); i++) {
                Bus c = (Bus) list2.get(i);
                System.out.print(count + "." + c.getPassengerCapacity() + "座  ");
                count++;
            }
            System.out.println("\n请选择你要租赁的客车载客量:");
            Bus c = (Bus) list2.get(sc.nextInt() - 1);
            c.leaseOutFlow();
        } else if (chose == 3) {
            ArrayList<Vehicle> list1 = ridRepeat1(list, 1, "货车");
            ArrayList<String> strlist = show(list1);
            System.out.println("\n请选择你要租赁的货车品牌:");
            ArrayList<Vehicle> list2 = ridRepeat1(list1, 2, strlist.get(sc.nextInt() - 1));
            int count = 1;
            for (int i = 0; i < list2.size(); i++) {
                Trunk c = (Trunk) list2.get(i);
                System.out.print(count + "." + c.getCargoCapacity() + "吨  ");
                count++;
            }
            System.out.println("\n请选择你要租赁的货车载重量:");
            Trunk c = (Trunk) list2.get(sc.nextInt() - 1);
            c.leaseOutFlow();
        }
        return false;
    }

    public ArrayList<Vehicle> ridRepeat1(ArrayList<Vehicle> list, int n, String str) {
        ArrayList<Vehicle> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            switch (n) {
                case 1:
                    if (list.get(i).getType().equals(str)) {
                        newList.add(list.get(i));
                    }
                    break;
                case 2:
                    if (list.get(i).getBrand().equals(str)) {
                        newList.add(list.get(i));
                    }
                    break;
                default:
                    break;
            }
        }
        return newList;
    }

    public ArrayList<String> show(ArrayList<Vehicle> list) {
        ArrayList<String> newList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            if (!newList.contains(list.get(i).getBrand())) {
                newList.add(list.get(i).getBrand());
                System.out.print(count + "." + list.get(i).getBrand() + "  ");
                count++;
            }
        }
        return newList;
    }
}