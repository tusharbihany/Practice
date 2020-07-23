package parkingLot.history;

import parkingLot.models.ParkingHistory;

import java.util.Set;

public interface HistoryDataStore {
    void addToHistory(ParkingHistory parkingHistory);
    Set<ParkingHistory> fetchHistory(String vehicleId);
}
