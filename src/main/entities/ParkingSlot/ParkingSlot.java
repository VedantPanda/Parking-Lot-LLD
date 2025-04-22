package main.entities.ParkingSlot;

import main.consts.VehicleType;
import main.entities.Vehicle;

public abstract class ParkingSlot {

    private final int parkingSlotNo;

    private Vehicle vehicle;

    private final VehicleType vehicleType;

    public ParkingSlot(int parkingSlotNo, VehicleType vehicleType) {
        this.parkingSlotNo = parkingSlotNo;
        this.vehicleType = vehicleType;
    }

    public int getParkingSlotNo() {
        return parkingSlotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getParkingSlotType() {
        return vehicleType;
    }

    public boolean isParkingSlotEmpty(){
        return vehicle == null;
    }

    public void parkVehicleAtParkingSlot(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void unParkVehicleFromParkingSlot(){
        this.vehicle = null;
    }

    protected abstract double price();

}
