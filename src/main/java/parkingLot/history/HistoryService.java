package parkingLot.history;

import parkingLot.models.ParkingHistory;

import java.util.Set;

public class HistoryService {

    private HistoryDataStore historyDataStore;

    public HistoryService() {
        historyDataStore = new MapHistoryDataStore();
    }

    public void addToHistory(ParkingHistory parkingHistory) {
        historyDataStore.addToHistory(parkingHistory);
    }

    public Set<ParkingHistory> fetchHistory(String vehicleId) {
        return historyDataStore.fetchHistory(vehicleId);
    }
}
