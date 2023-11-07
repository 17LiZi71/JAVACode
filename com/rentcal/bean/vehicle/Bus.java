package com.rentcal.bean.vehicle;

public class Bus extends Vehicle {
    private String passengerCapacity;

    // 客车类，继承自Vehicle类，拥有特有变量载客量
    // 定义带参，无参构造方法，以及公共的get set方法
    public Bus(String vehicleId, String brand, String type, int perRent, String state, String passengerCapacity) {
        super(vehicleId, brand, type, perRent, state);
        this.passengerCapacity = passengerCapacity;
    }

    public Bus() {

    }

    public Bus(String passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Bus(String vehicleId, String brand, String type, int perRent, String passengerCapacity) {
        super(vehicleId, brand, type, perRent);
        this.passengerCapacity = passengerCapacity;
    }

    public String getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(String passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

}
