package parkingLot.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class ParkingTicket {
    private Vehicle vehicle;
    private int slot;
    private long startTime;
}
