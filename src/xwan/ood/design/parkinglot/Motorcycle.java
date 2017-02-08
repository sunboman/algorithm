package xwan.ood.design.parkinglot;

/**
 * Created by xwan on 1/31/17.
 */
public class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = 1;
        vehicleSize = VehicleSize.MotorCycle;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    @Override
    public void print() {
        System.out.println("M");
    }
}
