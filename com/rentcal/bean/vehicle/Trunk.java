package com.rentcal.bean.vehicle;

public class Trunk extends Vehicle {
    private String cargoCapacity;

    // 货车类，继承自Vehicle类，拥有特有变量载货量
    // 定义带参，无参构造方法，以及公共的get set方法
    public Trunk(String vehicleId, String brand, String type, int perRent, String state, String cargoCapacity) {
        super(vehicleId, brand, type, perRent, state);
        this.cargoCapacity = cargoCapacity;
    }

    public Trunk() {

    }

    public Trunk(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public Trunk(String vehicleId, String brand, String type, int perRent, String cargoCapacity) {
        super(vehicleId, brand, type, perRent);
        this.cargoCapacity = cargoCapacity;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

}
