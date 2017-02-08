package xwan.ood.design.parkinglot;

/**
 * Created by xwan on 1/31/17.
 */
public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize vehicleSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(VehicleSize vehicleSize, int row, int spotNumber, Level level) {
        this.vehicleSize = vehicleSize;
        this.row = row;
        this.spotNumber = spotNumber;
        this.level = level;
    }

    public boolean isVailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v) {
        return isVailable() && v.canFitInSpot(this);
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    public void removeVehicle() {
        level.spotFeed();
        vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void print() {
        if (vehicle == null) {
            if (vehicleSize == VehicleSize.Compact) {
                System.out.println("Compact");
            } else if (vehicleSize == VehicleSize.Large) {
                System.out.println("Large");
            } else if (vehicleSize == VehicleSize.MotorCycle) {
                System.out.println("Motocycle");
            }
        } else {
            vehicle.print();
        }
    }
}
