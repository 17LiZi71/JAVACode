package com.rentcal.bean.vehicle;

public class Car extends Vehicle {
    private String Model;
    //轿车类，继承自Vehicle类，拥有特有变量型号
    //定义带参，无参构造方法，以及公共的get set方法
    public Car(String vehicleId, String brand, String type, int perRent, String state, String model) {
        super(vehicleId, brand, type, perRent, state);
        this.Model = model;
    }

    public Car() {
    }

    public Car(String model) {
        Model = model;
    }

    public Car(String vehicleId, String brand, String type, int perRent, String model) {
        super(vehicleId, brand, type, perRent);
        Model = model;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

}
