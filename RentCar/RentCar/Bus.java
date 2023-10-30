package RentCar.RentCar;

import java.util.Scanner;

import RentCar.RentMgrSys;

public class Bus extends Vehicle {//继承自Vehicle
    private int capacity;//特有成员变量：载客量
    Scanner sc = RentMgrSys.sc;

    public Bus(String vehicleId, String brand, int perRent, int capacity) {
        super(vehicleId, brand, perRent);
        this.capacity = capacity;
    }

    public Bus() {
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setType(int capacity) {
        this.capacity = capacity;
    }

    public void leaseOutFlow() {// 实现租赁
        System.out.println("请输入您要租赁的天数");
        int days = sc.nextInt();
        System.out.println("分配给您的汽车牌号是：" + this.getVehicleId());
        System.out.println("您需要支付的租赁费用是：" + calRent(days) + "元");
    }

    public float calRent(int days) {// 计算租金
        if (days >= 150) {
            return (float) (days * super.getPerRent() * 0.6);
        }
        if (days >= 30) {
            return (float) (days * super.getPerRent() * 0.7);
        }
        if (days >= 7) {
            return (float) (days * super.getPerRent() * 0.8);
        }
        if (days >= 3) {
            return (float) (days * super.getPerRent() * 0.9);
        }
        return days * super.getPerRent();
    }

}
