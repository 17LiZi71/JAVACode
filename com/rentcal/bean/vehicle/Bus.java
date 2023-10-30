package com.rentcal.bean.vehicle;

public class Bus extends Vehicle {
    private String passengerCapacity;

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
