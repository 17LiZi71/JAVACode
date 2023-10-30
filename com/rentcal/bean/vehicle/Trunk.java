package com.rentcal.bean.vehicle;

public class Trunk extends Vehicle {
    private String cargoCapacity;

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
