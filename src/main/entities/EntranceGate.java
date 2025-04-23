package main.entities;

import main.consts.VehicleType;
import main.entities.ParkingSlot.ParkingSlot;
import main.strategy.parkingstrategy.ParkingStrategy;
import main.vo.ParkingFloorAndParkingSlotVO;

import java.util.List;

public class EntranceGate {

    private final ParkingStrategy parkingStrategy;

    private final TicketManager ticketManager;

    public EntranceGate(ParkingStrategy parkingStrategy, TicketManager ticketManager) {
        this.parkingStrategy = parkingStrategy;
        this.ticketManager = ticketManager;
    }

    public ParkingFloorAndParkingSlotVO findParkingSlot(List<ParkingFloor> parkingFloors, VehicleType vehicleType) {
        return parkingStrategy.findParkingSlot(parkingFloors, vehicleType);
    }

    public void updateParkingSpot(ParkingSlot parkingSlot, Vehicle vehicle){
        parkingSlot.parkVehicleAtParkingSlot(vehicle);
    }

    public Ticket generateTicket(ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO, Vehicle vehicle,
                                 String startTime) {
        return ticketManager.generateTicket(parkingFloorAndParkingSlotVO, vehicle, startTime);
    }

}
