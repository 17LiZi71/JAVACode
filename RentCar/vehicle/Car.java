package RentCar.vehicle;

import java.util.Scanner;

import RentCar.RentMgr;

public class Car extends Vehicle implements LeaseOutFlow,CalRent{
    private String Model;
    Scanner sc = RentMgr.sc;

    public Car() {

    }

    public Car(String Model) {
        this.Model = Model;
    }

    public Car(String vehicleId, String brand, int perRent, String Model,String type) {
        super(vehicleId, brand, perRent,type);
        this.Model = Model;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    @Override
    public String toString() {
        return "Car [VehicleId=" + super.getVehicleId() + ", brand=" + super.getBrand() + ", perRent="
                + super.getPerRent() + "]";
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
