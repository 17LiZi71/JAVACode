package com.rentcal.bean.vehicle;

public abstract class Vehicle {// 抽象类Vehicle，所有种类车辆的父类
    private String vehicleId;
    // 车牌号
    private String brand;
    // 品牌
    private String type;
    // 类型
    private int perRent;
    // 日租金
    private String state;

    // 定义车辆所共有的变量
    // 定义带参，无参以及公共的get，set方法
    public Vehicle(String vehicleId, String brand, String type, int perRent, String state) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.type = type;
        this.perRent = perRent;
        this.state = state;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String brand, String type, int perRent) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.type = type;
        this.perRent = perRent;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPerRent() {
        return perRent;
    }

    public void setPerRent(int perRent) {
        this.perRent = perRent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
