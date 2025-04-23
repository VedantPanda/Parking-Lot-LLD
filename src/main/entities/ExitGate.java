package main.entities;

import main.strategy.paymentStrategy.PaymentStrategy;
import main.strategy.pricingStrategy.PricingStrategy;

public class ExitGate {

    private final TicketManager ticketManager;

    private final PaymentStrategy paymentStrategy;

    private final PricingStrategy pricingStrategy;

    public ExitGate(TicketManager ticketManager, PaymentStrategy paymentStrategy, PricingStrategy pricingStrategy) {
        this.ticketManager = ticketManager;
        this.paymentStrategy = paymentStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public void processVehicleExit(int ticketId) throws Exception {
        Ticket ticket = ticketManager.getTicket(ticketId);
        if(ticket!=null) {
            double parkingPrice = calculateParkingPrice(ticket);
            processPayment(parkingPrice);
            ticket.getParkingFloorAndParkingSlotVO().getParkingSlot().unParkVehicleFromParkingSlot();
        }
        else {
            throw new Exception("Invalid ticket id");
        }
    }

    private double calculateParkingPrice(Ticket ticket) {
        return ticket.getParkingFloorAndParkingSlotVO().getParkingSlot().price() * pricingStrategy.getPricing();
    }

    private void processPayment(double parkingFees) {
        paymentStrategy.processPayment(parkingFees);
    }

}
