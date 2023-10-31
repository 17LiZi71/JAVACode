package RentCarer.RentCar;

import java.util.Scanner;

import RentCarer.RentMgrSys;

public class Car extends Vehicle {// Car类继承自Vehicle类
    private String type;//特有属性：品牌
    Scanner sc = RentMgrSys.sc;

    public Car(String vehicleId, String brand, int perRent, String type) {
        super(vehicleId, brand, perRent);
        this.type = type;
    }

    public Car() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void leaseOutFlow() {// 实现租赁
        System.out.println("请输入您要租赁的天数");
        int days = sc.nextInt();
        System.out.println("分配给您的汽车牌号是：" + this.getVehicleId());
        System.out.println("您需要支付的租赁费用是：" + calRent(days) + "元");
    }

    public float calRent(int days) {// 计算租金
        if (days > 150) {
            return (float) (days * super.getPerRent() * 0.7);
        }
        if (days > 30) {
            return (float) (days * super.getPerRent() * 0.8);
        }
        if (days > 7) {
            return (float) (days * super.getPerRent() * 0.9);
        }
        return days * super.getPerRent();
    }
}
