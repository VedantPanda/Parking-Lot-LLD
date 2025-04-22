package main.entities;

import main.consts.VehicleType;
import main.entities.ParkingSlot.ParkingSlot;
import main.vo.ParkingFloorAndParkingSlotVO;

import java.util.List;

public class EntranceGate {

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

    public void updateParkingSpot(ParkingSlot parkingSlot, Vehicle vehicle){
        parkingSlot.parkVehicleAtParkingSlot(vehicle);
    }

    public Ticket generateTicket(ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO) {
        return new Ticket(parkingFloorAndParkingSlotVO, "00:00");
    }

}
