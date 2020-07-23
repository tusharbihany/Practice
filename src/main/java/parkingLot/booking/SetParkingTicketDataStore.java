package parkingLot.booking;

import parkingLot.models.ParkingTicket;

import java.util.HashSet;
import java.util.Set;

public class SetParkingTicketDataStore implements ParkingTicketDataStore{

    private Set<ParkingTicket> parkingTicketSet = new HashSet<ParkingTicket>();

    public boolean isValid(ParkingTicket parkingTicket) {
        return parkingTicketSet.contains(parkingTicket);
    }

    public synchronized void removeTicket(ParkingTicket parkingTicket) {
        parkingTicketSet.remove(parkingTicket);
    }

    public synchronized void addTicket(ParkingTicket parkingTicket) {
        parkingTicketSet.add(parkingTicket);
    }
}
