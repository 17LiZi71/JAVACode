package third.user;

import java.util.ArrayList;

import third.vehicle.Vehicle;

public interface Customer {
    void viewCarInformation(ArrayList<Vehicle> list);

    boolean rentalCar(ArrayList<Vehicle> list);
}
