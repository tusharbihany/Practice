package parkingLot.priceCalculator;

import parkingLot.models.ParkingTicket;

public class BasicFourWheelerPriceCalculator implements PriceCalculator{

    //Eager initialisation
    private static final PriceCalculator basicFourWheelerPriceCalculator = new BasicFourWheelerPriceCalculator();

    private BasicFourWheelerPriceCalculator()
    {}

    public static PriceCalculator getInstance() {
        return basicFourWheelerPriceCalculator;
    }

    public double calculatePrice(ParkingTicket parkingTicket) {
        long exitTime = System.currentTimeMillis();
        long totalTime = exitTime -parkingTicket.getStartTime();
        //long timeInMinutes = (exitTime - parkingTicket.getStartTime()) / 1000/ 60;
        if(totalTime <= 2.0)
            return 10;
        else
            return 10.0 + (totalTime - 2.0)*5;
    }
}
