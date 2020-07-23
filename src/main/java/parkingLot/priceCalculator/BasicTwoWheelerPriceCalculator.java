package parkingLot.priceCalculator;

import parkingLot.models.ParkingTicket;

public class BasicTwoWheelerPriceCalculator implements PriceCalculator{

    //Eager initialisation
    private static final BasicTwoWheelerPriceCalculator basicTwoWheelerPriceCalculator = new BasicTwoWheelerPriceCalculator();

    private BasicTwoWheelerPriceCalculator()
    {}

    public static PriceCalculator getInstance() {
        return basicTwoWheelerPriceCalculator;
    }

    public double calculatePrice(ParkingTicket parkingTicket) {
        long exitTime = System.currentTimeMillis();
        //long timeInMinutes = (exitTime - parkingTicket.getStartTime()) / 1000/ 60;
        return (exitTime-parkingTicket.getStartTime())*2;
    }
}
