package third.user;

import java.util.ArrayList;

import third.vehicle.Vehicle;

public interface StoreMgr {
    boolean modifyCarInformation(ArrayList<Vehicle> list);

    boolean addNewCars(ArrayList<Vehicle> list);

    boolean deleteCar(ArrayList<Vehicle> list);
}
