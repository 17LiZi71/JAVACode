package RentCar.user;

import java.util.ArrayList;

import RentCar.vehicle.Vehicle;

public interface StoreMgr {
    public boolean modifyCarInformation(ArrayList<Vehicle> list);

    public boolean addNewCars(ArrayList<Vehicle> list);

    public boolean deleteCar(ArrayList<Vehicle> list);
}
