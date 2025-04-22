package main.entities;

import main.consts.VehicleType;

public class Vehicle {

    private final String plate;

    private final VehicleType vehicleType;

    private Ticket ticket;

    public Vehicle(String plate, VehicleType vehicleType) {
        this.plate = plate;
        this.vehicleType = vehicleType;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getPlate() {
        return plate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
