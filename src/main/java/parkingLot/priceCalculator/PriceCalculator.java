package parkingLot.priceCalculator;

import parkingLot.models.ParkingTicket;

public interface PriceCalculator {
    double calculatePrice(ParkingTicket parkingTicket);
}
