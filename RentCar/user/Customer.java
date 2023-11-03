package RentCar.user;

import java.util.ArrayList;

import RentCar.vehicle.Vehicle;

public interface Customer {
    public void viewCarInformation(ArrayList<Vehicle> list);

    public boolean rentalCar(ArrayList<Vehicle> list);
}
