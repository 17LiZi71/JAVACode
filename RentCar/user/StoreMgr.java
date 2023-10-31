package RentCar.user;

import java.util.ArrayList;

import RentCar.vehicle.Vehicle;

public interface StoreMgr {
    boolean modifyCarInformation(ArrayList<Vehicle> list);

    boolean addNewCars(ArrayList<Vehicle> list);

    boolean deleteCar(ArrayList<Vehicle> list);
}
