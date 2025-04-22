package main.entities.ParkingSlot;

import main.consts.VehicleType;

public class SixWheelerParkingSlot extends ParkingSlot{

    public SixWheelerParkingSlot(int parkingSlotNo) {
        super(parkingSlotNo, VehicleType.SIX_WHEELER);
    }

    @Override
    protected double price() {
        return 60.0;
    }
}
