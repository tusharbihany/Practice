package parkingLot.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
}
