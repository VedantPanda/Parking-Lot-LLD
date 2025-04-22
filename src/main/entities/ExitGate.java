package main.entities;

public class ExitGate {

    public void unParkVehicleFromParkingSpot(Vehicle vehicle) {
        vehicle.getTicket().getParkingFloorAndParkingSlotVO().getParkingSlot().unParkVehicleFromParkingSlot();
    }

    public double calculateParkingPrice(Vehicle vehicle) {
        return 0.00;
    }

    public void processPayment(double parkingFees) {

    }

}
