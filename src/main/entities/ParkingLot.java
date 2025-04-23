package main.entities;

import main.vo.ParkingFloorAndParkingSlotVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

    private final List<ParkingFloor> parkingFloors;

    private final EntranceGate entranceGate;

    private final ExitGate exitGate;

    private final Scanner scanner;

    private static volatile ParkingLot parkingLotInstance;

    public static ParkingLot getParkingLotInstance(int noOfFloors, EntranceGate entranceGate, ExitGate exitGate){
        if(parkingLotInstance==null){
            synchronized(ParkingLot.class){
                if(parkingLotInstance==null){
                    parkingLotInstance = new ParkingLot(noOfFloors, entranceGate, exitGate);
                }
            }
        }
        return parkingLotInstance;
    }

    private ParkingLot(int noOfFloors, EntranceGate entranceGate, ExitGate exitGate) {
        parkingFloors = new ArrayList<>();
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
        initializeParkingFloors(noOfFloors);
        scanner = new Scanner(System.in);
    }

    private void initializeParkingFloors(int noOfFloors) {
        for (int i = 1; i <= noOfFloors; i++){
            System.out.println("Enter no of 2 wheeler parking slots");
            int twoWheelerSpots = scanner.nextInt();
            System.out.println("Enter no of 4 wheeler parking slots");
            int fourWheelerSpots = scanner.nextInt();
            System.out.println("Enter no of 4 wheeler parking slots");
            int sixWheelerSpots = scanner.nextInt();
            parkingFloors.add(new ParkingFloor(i, twoWheelerSpots, fourWheelerSpots, sixWheelerSpots));
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) throws Exception {
        ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO = entranceGate.findParkingSlot(parkingFloors,
                vehicle.getVehicleType());
        if(parkingFloorAndParkingSlotVO!=null){
            entranceGate.updateParkingSpot(parkingFloorAndParkingSlotVO.getParkingSlot(), vehicle);
            return entranceGate.generateTicket(parkingFloorAndParkingSlotVO, vehicle, "00:00");
        }
        else {
            throw new Exception("No parking spot is available");
        }
    }

    public void exitVehicle(int ticketId) {
        exitGate.processVehicleExit(ticketId);
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public EntranceGate getEntranceGate() {
        return entranceGate;
    }

    public ExitGate getExitGate() {
        return exitGate;
    }

}
