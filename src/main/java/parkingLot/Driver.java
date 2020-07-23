package parkingLot;

import parkingLot.controller.ParkingLotController;
import parkingLot.models.ParkingHistory;
import parkingLot.models.ParkingTicket;
import parkingLot.models.Vehicle;
import parkingLot.models.VehicleType;

import java.util.Set;

public class Driver {

    public static void main(String args[]) throws Exception {
        ParkingLotController parkingLotController = new ParkingLotController();
        Vehicle vehicle1 = new Vehicle("1", VehicleType.TWO_WHEELER);
        boolean available = parkingLotController.isSlotAvailable(vehicle1);
        ParkingTicket parkingTicket1 = parkingLotController.parkVehicle(vehicle1);
        System.out.println(parkingTicket1);

        Vehicle vehicle2 = new Vehicle("2", VehicleType.TWO_WHEELER);
        ParkingTicket parkingTicket2 = parkingLotController.parkVehicle(vehicle2);
        System.out.println(parkingTicket2);

        Vehicle vehicle3 = new Vehicle("3", VehicleType.FOUR_WHEELER);
        ParkingTicket parkingTicket3 = parkingLotController.parkVehicle(vehicle3);
        System.out.println(parkingTicket3);

        double price1 = parkingLotController.getVehicle(parkingTicket1);
        double price3 = parkingLotController.getVehicle(parkingTicket3);

        System.out.println(price1);
        System.out.println(price3);

        parkingTicket3 = parkingLotController.parkVehicle(vehicle3);
        price3 = parkingLotController.getVehicle(parkingTicket3);
        System.out.println(price3);

        Set<ParkingHistory> parkingHistories = parkingLotController.getHistory(vehicle3.getVehicleNumber());
        for(ParkingHistory parkingHistory : parkingHistories)
            System.out.println(parkingHistory);

        //Dummy ParkingTicket
        //ParkingTicket parkingTicketInvalid = new ParkingTicket(parkingTicket1.getVehicle(),parkingTicket1.getSlot(),parkingTicket1.getStartTime());
        //double priceInvalid = parkingLotController.getVehicle(parkingTicketInvalid);
    }
}
