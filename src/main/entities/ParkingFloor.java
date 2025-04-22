package main.entities;

import main.consts.VehicleType;
import main.entities.ParkingSlot.ParkingSlot;
import main.factory.ParkingSlotFactory;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private final int floorNo;

    private final int noOfTwoWheelerParkingSlots;

    private final int noOfFourWheelerParkingSlots;

    private final int noOfSixWheelerParkingSlots;

    private final List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNo, int noOfTwoWheelerParkingSlots, int noOfFourWheelerParkingSlots,
                        int noOfSixWheelerParkingSlots) {
        this.floorNo = floorNo;
        this.noOfFourWheelerParkingSlots = noOfFourWheelerParkingSlots;
        this.noOfSixWheelerParkingSlots = noOfSixWheelerParkingSlots;
        this.noOfTwoWheelerParkingSlots = noOfTwoWheelerParkingSlots;
        parkingSlots = new ArrayList<>();
        initializeParkingSlots();
    }

    public int getFloorNo() {
        return floorNo;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    private void initializeParkingSlots() {
        initializeParkingSlotsHelper(noOfTwoWheelerParkingSlots, VehicleType.TWO_WHEELER);
        initializeParkingSlotsHelper(noOfFourWheelerParkingSlots, VehicleType.FOUR_WHEELER);
        initializeParkingSlotsHelper(noOfSixWheelerParkingSlots, VehicleType.SIX_WHEELER);
    }

    private void initializeParkingSlotsHelper(int noOfParkingSlots, VehicleType vehicleType) {
        for(int i= parkingSlots.size() ; i < parkingSlots.size() + noOfParkingSlots; i++){
            ParkingSlot parkingSlot = ParkingSlotFactory.getParkingSlot(i+1, vehicleType);
            parkingSlots.add(parkingSlot);
        }
    }
}
