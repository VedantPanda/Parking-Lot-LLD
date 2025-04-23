package main.entities;

import main.vo.ParkingFloorAndParkingSlotVO;

import java.util.HashMap;
import java.util.Map;

public class TicketManager {

    private final Map<Integer, Ticket> ticketMap;

    public TicketManager() {
        ticketMap = new HashMap<>();
    }

    public Ticket getTicket(int ticketId) {
        return ticketMap.get(ticketId);
    }

    public Ticket generateTicket(ParkingFloorAndParkingSlotVO parkingFloorAndParkingSlotVO, Vehicle vehicle,
                               String startTime) {
        Ticket ticket = new Ticket(parkingFloorAndParkingSlotVO, vehicle, startTime, ticketMap.size() + 1);
        ticketMap.put(ticket.getTicketId(), ticket);
        return ticket;
    }

}
