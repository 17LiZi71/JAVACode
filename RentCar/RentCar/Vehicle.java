package RentCar.RentCar;

public class Vehicle {// 所有车类的父类
    private String vehicleId;// 共有属性：车牌，品牌，租金
    private String brand;
    private int perRent;

    public Vehicle(String vehicleId, String brand, int perRent) {// 带参构造
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.perRent = perRent;
    }

    public Vehicle() {// 无参构造
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPerRent() {
        return perRent;
    }

    public void setPerRent(int perRent) {
        this.perRent = perRent;
    }

}
