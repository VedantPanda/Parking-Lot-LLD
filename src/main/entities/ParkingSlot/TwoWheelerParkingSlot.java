package main.entities.ParkingSlot;

import main.consts.VehicleType;

import java.sql.PseudoColumnUsage;

public class TwoWheelerParkingSlot extends ParkingSlot{

    public TwoWheelerParkingSlot(int parkingSlotNo) {
        super(parkingSlotNo, VehicleType.TWO_WHEELER);
    }

    @Override
    protected double price() {
        return 20.0;
    }
}
