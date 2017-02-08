package xwan.ood.design.parkinglot;

/**
 * Created by xwan on 1/31/17.
 */
public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        vehicleSize = VehicleSize.Compact;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getVehicleSize() == VehicleSize.Large || spot.getVehicleSize() == VehicleSize.Compact;
    }

    @Override
    public void print() {
        System.out.println("C");
    }
}
