package main.entities;

import main.vo.ParkingFloorAndParkingSlotVO;

public class Ticket {

    private final int ticketId;

    private final ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO;

    private final String startTime;

    private final Vehicle vehicle;

    public Ticket(ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO, Vehicle vehicle, String startTime,
                  int ticketId) {
        this.parkingFloorAndParkingSlotVO = parkingFloorAndParkingSlotVO;
        this.startTime = startTime;
        this.ticketId = ticketId;
        this.vehicle = vehicle;
    }

    public ParkingFloorAndParkingSlotVO getParkingFloorAndParkingSlotVO() {
        return parkingFloorAndParkingSlotVO;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
