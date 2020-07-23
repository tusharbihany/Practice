package parkingLot.dataStore;

import parkingLot.models.Vehicle;
import parkingLot.models.VehicleType;

import java.util.EnumMap;
import java.util.Map;

public class LotService {

    private Map<VehicleType, ParkingLotDataStore> vehicleTypeToLot = new EnumMap<VehicleType, ParkingLotDataStore>(VehicleType.class);

    public LotService() {
        ParkingLotDataStore twoWheelerParkingLotDataStore = new LinkedListParkingLotDataStore(1);
        ParkingLotDataStore fourWheelerParkingLotDataStore = new LinkedListParkingLotDataStore(2);
        vehicleTypeToLot.put(VehicleType.TWO_WHEELER, twoWheelerParkingLotDataStore);
        vehicleTypeToLot.put(VehicleType.FOUR_WHEELER, fourWheelerParkingLotDataStore);
    }

    public boolean isSlotAvailable(VehicleType vehicleType) {
        return vehicleTypeToLot.get(vehicleType).isSlotAvailable();
    }

    public Integer addVehicle(Vehicle vehicle) {
        if(isSlotAvailable(vehicle.getVehicleType()))
            return vehicleTypeToLot.get(vehicle.getVehicleType()).addVehicle(vehicle);
        else
            return null;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return vehicleTypeToLot.get(vehicle.getVehicleType()).removeVehicle(vehicle);
    }
}