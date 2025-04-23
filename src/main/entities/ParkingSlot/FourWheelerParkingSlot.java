package main.entities.ParkingSlot;

import main.consts.VehicleType;

public class FourWheelerParkingSlot extends ParkingSlot{

    public FourWheelerParkingSlot(int parkingSlotNo) {
        super(parkingSlotNo, VehicleType.FOUR_WHEELER);
    }

    @Override
    public double price() {
        return 40.0;
    }
}
