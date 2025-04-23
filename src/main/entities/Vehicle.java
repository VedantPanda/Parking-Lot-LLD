package main.entities;

import main.consts.VehicleType;

public class Vehicle {

    private final String plate;

    private final VehicleType vehicleType;

    public Vehicle(String plate, VehicleType vehicleType) {
        this.plate = plate;
        this.vehicleType = vehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
