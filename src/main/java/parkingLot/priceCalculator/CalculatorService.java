package parkingLot.priceCalculator;

import parkingLot.models.ParkingTicket;
import parkingLot.models.VehicleType;

import java.util.EnumMap;
import java.util.Map;

public class CalculatorService {
    private Map<VehicleType,PriceCalculator> vehicleTypeToPrice = new EnumMap<VehicleType,PriceCalculator>(VehicleType.class);
    private static final CalculatorService calculatorService = new CalculatorService();

    private CalculatorService() {
        // Price Calculator per vehicle type
        vehicleTypeToPrice.put(VehicleType.TWO_WHEELER, BasicTwoWheelerPriceCalculator.getInstance());
        vehicleTypeToPrice.put(VehicleType.FOUR_WHEELER, BasicFourWheelerPriceCalculator.getInstance());
    }

    public static CalculatorService getInstance() {
        return calculatorService;
    }

    public double calculatePrice(ParkingTicket parkingTicket) throws Exception {
        if(!vehicleTypeToPrice.containsKey(parkingTicket.getVehicle().getVehicleType()))
            throw new Exception("Invalid Vehicle Type");
        else
            return vehicleTypeToPrice.get(parkingTicket.getVehicle().getVehicleType()).calculatePrice(parkingTicket);
    }
}
