package third.vehicle;

import java.util.Scanner;

import third.RentMgr;

public class Trunk extends Vehicle implements LeaseOutFlow,CalRent{
    private int cargoCapacity;
    Scanner sc = RentMgr.sc;
    public Trunk() {

    }

    public Trunk(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public Trunk(String vehicleId, String brand, int perRent, int cargoCapacity,String type) {
        super(vehicleId, brand, perRent,type);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return "Trunk [VehicleId=" + super.getVehicleId() + ", brand=" + super.getBrand() + ", perRent="
                + super.getPerRent() + "]";
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