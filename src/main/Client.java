package main;

import main.consts.VehicleType;
import main.entities.ParkingLot;
import main.entities.Ticket;
import main.entities.Vehicle;

public class Client {
    public static void main(String[] args) {
        try {
            ParkingLot parkingLot = ParkingLot.getParkingLotInstance();
            Vehicle vehicle = new Vehicle("123", VehicleType.FOUR_WHEELER);
            Ticket ticket = parkingLot.parkVehicle(vehicle);
            System.out.println("Floor assigned: "+ticket.getParkingFloorAndParkingSlotVO().getParkingFloor().getFloorNo());
            System.out.println("Parking Slot No: "+ticket.getParkingFloorAndParkingSlotVO().getParkingSlot().getParkingSlotNo());
            parkingLot.exitVehicle(ticket.getTicketId());
            Vehicle vehicle1 = new Vehicle("123", VehicleType.SIX_WHEELER);
            Ticket ticket1 = parkingLot.parkVehicle(vehicle1);
            System.out.println("Floor assigned: "+ticket1.getParkingFloorAndParkingSlotVO().getParkingFloor().getFloorNo());
            System.out.println("Parking Slot No: "+ticket1.getParkingFloorAndParkingSlotVO().getParkingSlot().getParkingSlotNo());
            parkingLot.exitVehicle(ticket1.getTicketId());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
