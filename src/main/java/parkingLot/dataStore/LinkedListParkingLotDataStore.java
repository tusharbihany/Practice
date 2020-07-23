package parkingLot.dataStore;

import parkingLot.models.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class LinkedListParkingLotDataStore extends ParkingLotDataStore{

    private List<Vehicle> parkedVehicles = new LinkedList<Vehicle>();

    public LinkedListParkingLotDataStore(int capacity) {
        super(capacity);
    }

    public synchronized boolean isSlotAvailable() {
        return parkedVehicles.size() < capacity;
    }

    public synchronized Integer addVehicle(Vehicle vehicle) {
        parkedVehicles.add(vehicle);
        return parkedVehicles.size()-1;
    }

    public synchronized boolean removeVehicle(Vehicle vehicle) {
        return parkedVehicles.remove(vehicle);
    }
}
