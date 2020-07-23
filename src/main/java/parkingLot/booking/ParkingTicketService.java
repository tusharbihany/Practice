package parkingLot.booking;

import parkingLot.models.ParkingTicket;

public class ParkingTicketService {

    private ParkingTicketDataStore parkingTicketDataStore;

    public ParkingTicketService() {
        parkingTicketDataStore = new SetParkingTicketDataStore();
    }

    public boolean isValid(ParkingTicket parkingTicket) {
        return parkingTicketDataStore.isValid(parkingTicket);
    }

    public void removeTicket(ParkingTicket parkingTicket) {
        parkingTicketDataStore.removeTicket(parkingTicket);
    }

    public void addTicket(ParkingTicket parkingTicket) {
        parkingTicketDataStore.addTicket(parkingTicket);
    }
}


