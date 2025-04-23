package main.strategy.parkingstrategy;

import main.consts.VehicleType;
import main.entities.ParkingFloor;
import main.vo.ParkingFloorAndParkingSlotVO;

import java.util.List;

public interface ParkingStrategy {

    ParkingFloorAndParkingSlotVO findParkingSlot(List<ParkingFloor> parkingFloorList, VehicleType vehicleType);

}
