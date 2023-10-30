package third;

import java.util.ArrayList;
import java.util.Scanner;

import third.user.DefaultCustomer;
import third.user.DefaultStoreMgr;
import third.user.User;
import third.vehicle.Bus;
import third.vehicle.Car;
import third.vehicle.Trunk;
import third.vehicle.Vehicle;

public class RentMgr {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Vehicle> list = new ArrayList<>();
        list.add(new Car("京NY28588", "宝马", 600, "550i", "轿车"));
        list.add(new Car("京CNY3284", "宝马", 800, "X6", "轿车"));
        list.add(new Car("京NT37465", "别克", 300, "林荫大道", "轿车"));
        list.add(new Car("京NT96968", "别克", 600, "GL8", "轿车"));
        list.add(new Bus("京6566754", "金杯", 800, 16, "客车"));
        list.add(new Bus("京8696997", "金杯", 1800, 34, "客车"));
        list.add(new Bus("京9696996", "金龙", 1500, 16, "客车"));
        list.add(new Bus("京8696998", "金龙", 2000, 34, "客车"));
        list.add(new Trunk("京8697998", "大运", 1700, 3, "货车"));
        list.add(new Trunk("京8667998", "大运", 2100, 5, "货车"));
        list.add(new Trunk("京8647998", "东风", 1700, 3, "货车"));
        list.add(new Trunk("京8637998", "东风", 2100, 5, "货车"));
        System.out.println("**********欢迎光临租赁公司**********");
        User u = null;
        while (u == null) {
            u = new User().logOn();
        }
        if (u instanceof DefaultCustomer) {
            DefaultCustomer dcuser = (DefaultCustomer) u;
            System.out.println("按1查看汽车,按2租赁汽车,按3退出系统");
            int choose1 = 0;
            while (choose1 != 3) {
                choose1 = sc.nextInt();
                switch (choose1) {
                    case 1:
                        dcuser.viewCarInformation(list);
                        break;
                    case 2:
                        dcuser.rentalCar(list);
                        break;
                    case 3:
                        choose1 = 3;
                        break;
                    default:
                        break;
                }
            }
        } else if (u instanceof DefaultStoreMgr) {
            DefaultStoreMgr deStoreMgr = (DefaultStoreMgr) u;
            System.out.println("按1修改汽车,按2增加汽车,按3删除汽车,按4退出系统");
            int choose1 = 0;
            while (choose1 != 4) {
                choose1 = sc.nextInt();
                switch (choose1) {
                    case 1:
                        deStoreMgr.modifyCarInformation(list);
                        break;
                    case 2:
                        deStoreMgr.addNewCars(list);
                        break;
                    case 3:
                        deStoreMgr.deleteCar(list);
                        break;
                    case 4:
                        choose1 = 4;
                        break;
                    case 5:
                    deStoreMgr.viewCarInformation(list);
                    break;
                    default:
                        break;
                }
            }
        }
        sc.close();
    }
}
