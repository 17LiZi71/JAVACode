package com.rentcal.bean.vehicle;

public class Car extends Vehicle {
    private String Model;

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
