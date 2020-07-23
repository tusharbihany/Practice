package parkingLot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class ParkingHistory {
    private int slot;
    private String vehicleId;
    private double amount;
    private double duration;
}
