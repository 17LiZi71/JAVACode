package RentCar.user;

import java.util.ArrayList;

import RentCar.vehicle.Vehicle;

public interface Customer {
    void viewCarInformation(ArrayList<Vehicle> list);

    boolean rentalCar(ArrayList<Vehicle> list);
}
