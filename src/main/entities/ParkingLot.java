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

    public ParkingLot(int noOfFloors, EntranceGate entranceGate, ExitGate exitGate) {
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

    public void parkVehicle(Vehicle vehicle) {
        ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO = entranceGate.findParkingSlot(parkingFloors, vehicle.getVehicleType());
        if(parkingFloorAndParkingSlotVO!=null){
            entranceGate.updateParkingSpot(parkingFloorAndParkingSlotVO.getParkingSlot(), vehicle);
            Ticket ticket = entranceGate.generateTicket(parkingFloorAndParkingSlotVO);
            vehicle.setTicket(ticket);
        }
    }

    public void exitVehicle(Vehicle vehicle) {
        double parkingFees = exitGate.calculateParkingPrice(vehicle);
        exitGate.processPayment(parkingFees);
        exitGate.unParkVehicleFromParkingSpot(vehicle);
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
