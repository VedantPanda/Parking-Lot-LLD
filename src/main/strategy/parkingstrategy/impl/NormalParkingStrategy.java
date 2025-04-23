package main.strategy.parkingstrategy.impl;

import main.consts.VehicleType;
import main.entities.ParkingFloor;
import main.entities.ParkingSlot.ParkingSlot;
import main.strategy.parkingstrategy.ParkingStrategy;
import main.vo.ParkingFloorAndParkingSlotVO;

import java.util.List;

public class NormalParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingFloorAndParkingSlotVO findParkingSlot(List<ParkingFloor> parkingFloors, VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : parkingFloors) {
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
                if(parkingSlot.isParkingSlotEmpty() && vehicleType.equals(parkingSlot.getParkingSlotType())) {
                    return new ParkingFloorAndParkingSlotVO(parkingFloor, parkingSlot);
                }
            }
        }
        return null;
    }
}
