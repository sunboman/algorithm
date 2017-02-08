package xwan.ood.design.parkinglot;

/**
 * Created by xwan on 1/31/17.
 */
public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private int SPOTS_PER_ROW;

    public Level(int floor, int num_rows, int SPOTS_PER_ROW) {
        this.floor = floor;
        this.SPOTS_PER_ROW = SPOTS_PER_ROW;
        spots = new ParkingSpot[num_rows * SPOTS_PER_ROW];
        int numberSpots = 0;

        for (int row = 0; row < num_rows; ++row) {
            for (int spot = 0; spot < SPOTS_PER_ROW / 4; ++spot) {
                VehicleSize vs = VehicleSize.MotorCycle;
                spots[numberSpots] = new ParkingSpot(vs, row, numberSpots, this);
                numberSpots++;
            }
            for (int spot = SPOTS_PER_ROW / 4; spot < SPOTS_PER_ROW / 4 * 3; ++spot) {
                VehicleSize vs = VehicleSize.Compact;
                spots[numberSpots] = new ParkingSpot(vs, row, numberSpots, this);
                numberSpots++;
            }
            for (int spot = SPOTS_PER_ROW / 4 * 3; spot < SPOTS_PER_ROW; ++spot) {
                VehicleSize vs = VehicleSize.Large;
                spots[numberSpots] = new ParkingSpot(vs, row, numberSpots, this);
                numberSpots++;
            }
        }

        availableSpots = numberSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots < vehicle.getSpotsNeeded()) {
            return false;
        }
        int sportNums = findAvailableSpots(vehicle);
        if (sportNums < 0) {
            return false;
        }
        return parkingStartAtSpot(sportNums, vehicle);
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFount = 0;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (lastRow != spot.getRow()) {
                spotsFount = 0;
                lastRow = spot.getRow();
            }
            if (spot.canFitVehicle(vehicle)) {
                spotsFount++;
            } else {
                spotsFount = 0;
            }
            if (spotsFount == spotNeeded) {
                return i - (spotNeeded - 1);
            }
        }
        return -1;
    }

    public boolean parkingStartAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpot();
        boolean success = true;

        for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.spotsNeeded;
        return success;
    }

    public void spotFeed() {
        availableSpots++;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public void print() {
        int lastRow = -1;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (spot.getRow() != lastRow) {
                System.out.print("  ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }
}
