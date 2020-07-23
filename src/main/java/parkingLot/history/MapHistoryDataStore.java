package parkingLot.history;

import parkingLot.models.ParkingHistory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapHistoryDataStore implements HistoryDataStore {

    private Map<String,Set<ParkingHistory>> history = new ConcurrentHashMap();

    public void addToHistory(ParkingHistory parkingHistory) {
        if(history.containsKey(parkingHistory.getVehicleId()))
            history.get(parkingHistory.getVehicleId()).add(parkingHistory);
        else
            history.put(parkingHistory.getVehicleId(),new HashSet<ParkingHistory>(Arrays.asList(parkingHistory)));
    }

    public Set<ParkingHistory> fetchHistory(String vehicleId) {
        return history.get(vehicleId);
    }
}
