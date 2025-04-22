package main.entities;

import main.vo.ParkingFloorAndParkingSlotVO;

public class Ticket {

    private final ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO;

    private final String startTime;

    public Ticket(ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO, String startTime) {
        this.parkingFloorAndParkingSlotVO = parkingFloorAndParkingSlotVO;
        this.startTime = startTime;
    }

    public ParkingFloorAndParkingSlotVO getParkingFloorAndParkingSlotVO() {
        return parkingFloorAndParkingSlotVO;
    }

    public String getStartTime() {
        return startTime;
    }

}
