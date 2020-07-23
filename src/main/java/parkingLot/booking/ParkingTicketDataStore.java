package parkingLot.booking;

import parkingLot.models.ParkingTicket;

public interface ParkingTicketDataStore {
    boolean isValid(ParkingTicket parkingTicket);
    void removeTicket(ParkingTicket parkingTicket);
    void addTicket(ParkingTicket parkingTicket);
}
