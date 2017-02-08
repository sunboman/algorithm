package xwan.ood.design.parkinglot;

/**
 * Created by xwan on 1/31/17.
 */
public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        vehicleSize = VehicleSize.Large;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getVehicleSize() == VehicleSize.Large;
    }

    @Override
    public void print() {
        System.out.println("B");
    }
}
