package main.vo;

import main.entities.ParkingFloor;
import main.entities.ParkingSlot.ParkingSlot;

public class ParkingFloorAndParkingSlotVO {

    private final ParkingFloor parkingFloor;

    private final ParkingSlot parkingSlot;

    public ParkingFloorAndParkingSlotVO(ParkingFloor parkingFloor, ParkingSlot parkingSlot) {
        this.parkingFloor = parkingFloor;
        this.parkingSlot = parkingSlot;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
}
