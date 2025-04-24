package main.entities;

import main.consts.ParkingMethod;
import main.factory.ParkingStrategyFactory;
import main.vo.ParkingFloorAndParkingSlotVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

    private final List<ParkingFloor> parkingFloors;

    private final EntranceGate entranceGate;

    private final ExitGate exitGate;

    private final Scanner scanner;

    private static class ParkingLotSingleton {
        private static final ParkingLot PARKING_LOT_INSTANCE = new ParkingLot();
    }

    public static ParkingLot getParkingLotInstance() {
        return ParkingLotSingleton.PARKING_LOT_INSTANCE;
    }

    private ParkingLot() {
        scanner = new Scanner(System.in);
        System.out.println("Enter the number of floors");
        int noOfFloors = scanner.nextInt();
        TicketManager ticketManager = new TicketManager();
        EntranceGate entranceGate = new EntranceGate(
                ParkingStrategyFactory.getParkingStrategy(ParkingMethod.NORMAL_PARKING), ticketManager);
        ExitGate exitGate = new ExitGate(ticketManager);
        parkingFloors = new ArrayList<>();
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
        initializeParkingFloors(noOfFloors);

    }

    private void initializeParkingFloors(int noOfFloors) {
        for (int i = 1; i <= noOfFloors; i++){
            System.out.println("Enter details for "+i+" floor");
            System.out.println("Enter no of 2 wheeler parking slots");
            int twoWheelerSpots = scanner.nextInt();
            System.out.println("Enter no of 4 wheeler parking slots");
            int fourWheelerSpots = scanner.nextInt();
            System.out.println("Enter no of 6 wheeler parking slots");
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

    public void exitVehicle(int ticketId) throws Exception {
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
