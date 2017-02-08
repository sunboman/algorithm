package xwan.ood.design.parkinglot;

/**
 * Created by xwan on 1/31/17.
 */
public class ParkingLot {
    private Level[] levels;
    private int NUM_LEVELS;

    public ParkingLot(int n, int num_rows, int spots_per_row) {
        NUM_LEVELS = n;
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, num_rows, spots_per_row);
        }
    }
    public boolean parkingVehicle(Vehicle vehicle) {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void unParkVehicle(Vehicle vehicle) {
        vehicle.clearSpot();
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level" + i + ": ");
            levels[i].print();
            System.out.println("");
        }
        System.out.println("");
    }
}
