package RentCarer;

import java.util.Scanner;

import RentCarer.RentCar.Bus;
import RentCarer.RentCar.Car;
import RentCarer.RentCar.Trunk;

public class RentMgrSys {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Car car1 = new Car("京NY28588", "宝马", 600, "550i");
        Car car2 = new Car("京CNY3284", "宝马", 800, "X6");
        Car car3 = new Car("京NT37465", "别克", 300, "林荫大道");
        Car car4 = new Car("京NT96968", "别克", 600, "GL8");
        Bus bus1 = new Bus("京6566754", "金杯", 800, 16);
        Bus bus2 = new Bus("京8696997", "金杯", 1800, 34);
        Bus bus3 = new Bus("京9696996", "金龙", 1500, 16);
        Bus bus4 = new Bus("京8696998", "金龙", 2000, 34);
        Trunk trunk1 = new Trunk("京8697998", "大运", 1700, 3);
        Trunk trunk2 = new Trunk("京8667998", "大运", 2100, 5);
        Trunk trunk3 = new Trunk("京8647998", "东风", 1700, 3);
        Trunk trunk4 = new Trunk("京8637998", "东风", 2100, 5);
        System.out.println("**********欢迎光临租赁公司**********");
        System.out.println("1.轿车  2.客车  3.货车");
        System.out.println("请选择你要租赁的轿车类型");
        int chose = sc.nextInt();
        if (chose == 1) {
            System.out.println("1.宝马  2.别克");
            System.out.println("请选择你要租赁的轿车品牌");
            int choose = sc.nextInt();
            // 选择车辆品牌
            switch (choose) {
                case 1:
                    System.out.println("1.550i  2.X6");
                    System.out.println("请选择你要租赁的轿车型号");
                    int choose2 = sc.nextInt();
                    if (choose2 == 1) {
                        car1.leaseOutFlow();
                        // 实现租赁
                        // 根据车辆信息，调用具体车辆对象的leaseOutFlow方法
                    } else if (choose2 == 2) {
                        car2.leaseOutFlow();
                    }
                    break;
                case 2:
                    System.out.println("1.林荫大道  2.GL8");
                    System.out.println("请选择你要租赁的轿车型号");
                    int choose3 = sc.nextInt();
                    if (choose3 == 1) {
                        car3.leaseOutFlow();
                    } else if (choose3 == 2) {
                        car4.leaseOutFlow();
                    }
                    break;
                default:
                    break;
            }
        } else if (chose == 2) {
            System.out.println("1.金杯  2.金龙");
            System.out.println("请选择你要租赁的客车品牌");
            int choose = sc.nextInt();
            // 选择车辆品牌
            switch (choose) {
                case 1:
                    System.out.println("1.16座  2.34座");
                    System.out.println("请选择客车座位数");
                    int choose2 = sc.nextInt();
                    if (choose2 == 1) {
                        bus1.leaseOutFlow();
                        // 实现租赁
                        // 根据车辆信息，调用具体车辆对象的leaseOutFlow方法
                    } else if (choose2 == 2) {
                        bus2.leaseOutFlow();
                    }
                    break;
                case 2:
                    System.out.println("1.16座  2.34座");
                    System.out.println("请选择客车座位数");
                    int choose3 = sc.nextInt();
                    if (choose3 == 1) {
                        bus3.leaseOutFlow();
                    } else if (choose3 == 2) {
                        bus4.leaseOutFlow();
                    }
                    break;
                default:
                    break;
            }
        } else if (chose == 3) {
            System.out.println("1.大运  2.东风");
            System.out.println("请选择你要租赁的货车品牌");
            int choose = sc.nextInt();
            // 选择车辆品牌
            switch (choose) {
                case 1:
                    System.out.println("1.3吨  2.5吨");
                    System.out.println("请选择货车载重量");
                    int choose2 = sc.nextInt();
                    if (choose2 == 1) {
                        trunk1.leaseOutFlow();
                        // 实现租赁
                        // 根据车辆信息，调用具体车辆对象的leaseOutFlow方法
                    } else if (choose2 == 2) {
                        trunk2.leaseOutFlow();
                    }
                    break;
                case 2:
                    System.out.println("1.3吨  2.5吨");
                    System.out.println("请选择货车载重量");
                    int choose3 = sc.nextInt();
                    if (choose3 == 1) {
                        trunk3.leaseOutFlow();
                    } else if (choose3 == 2) {
                        trunk4.leaseOutFlow();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
