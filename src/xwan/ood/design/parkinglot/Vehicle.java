package xwan.ood.design.parkinglot;

import java.util.ArrayList;

/**
 * Created by xwan on 1/31/17.
 */

/**
 * Design a parking lot.

     see CC150 OO Design for details.
     1) n levels, each level has m rows of spots and each row has k spots.So each level has m x k spots.
     2) The parking lot can park motorcycles, cars and buses
     3) The parking lot has motorcycle spots, compact spots, and large spots
     4) Each row, motorcycle spots id is in range [0,k/4)(0 is included, k/4 is not included), compact spots id is in range [k/4,k/4*3) and large spots id is in range [k/4*3,k).
     5) A motorcycle can park in any spot
     6) A car park in single compact spot or large spot
     7) A bus can park in five large spots that are consecutive and within same row. it can not park in small spots
 */
public abstract class Vehicle {
    protected int spotsNeeded;
    protected String licensePlate;
    protected VehicleSize vehicleSize;
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpot() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
