package parkingLot.dataStore;

import parkingLot.models.Vehicle;

public abstract class ParkingLotDataStore {

    protected int capacity;

    public ParkingLotDataStore(int capacity) {
        this.capacity = capacity;
    }

    abstract boolean isSlotAvailable();
    abstract Integer addVehicle(Vehicle vehicle);
    abstract boolean removeVehicle(Vehicle vehicle);
}
