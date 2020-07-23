package parkingLot.controller;


import parkingLot.booking.ParkingTicketService;
import parkingLot.dataStore.LotService;
import parkingLot.history.HistoryService;
import parkingLot.models.ParkingHistory;
import parkingLot.models.ParkingTicket;
import parkingLot.models.Vehicle;
import parkingLot.priceCalculator.CalculatorService;

import java.util.Set;

public class ParkingLotController {

    private LotService lotService;
    private CalculatorService calculatorService;
    private HistoryService historyService;
    private ParkingTicketService parkingTicketService;

    public ParkingLotController() {
        lotService = new LotService();
        calculatorService = CalculatorService.getInstance();
        historyService = new HistoryService();
        parkingTicketService = new ParkingTicketService();
    }

    public boolean isSlotAvailable(Vehicle vehicle) {
        return lotService.isSlotAvailable(vehicle.getVehicleType());
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        Integer slot = lotService.addVehicle(vehicle);
        if(slot == null)
            return null;
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, slot, System.currentTimeMillis());
        parkingTicketService.addTicket(parkingTicket);
        return parkingTicket;
    }

    public Double getVehicle(ParkingTicket parkingTicket) throws Exception {
        if(!parkingTicketService.isValid(parkingTicket))
            return null;
        double price = calculatorService.calculatePrice(parkingTicket);
        long duration = System.currentTimeMillis() - parkingTicket.getStartTime();
        ParkingHistory parkingHistory = new ParkingHistory(parkingTicket.getSlot(),parkingTicket.getVehicle().getVehicleNumber(),
                price, duration);
        historyService.addToHistory(parkingHistory);
        parkingTicketService.removeTicket(parkingTicket);
        return price;
    }

    public Set<ParkingHistory> getHistory(String vehicleId) {
        return historyService.fetchHistory(vehicleId);
    }
}
