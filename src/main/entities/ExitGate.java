package main.entities;

import main.consts.PaymentMethod;
import main.consts.PricingMethod;
import main.factory.PaymentStrategyFactory;
import main.factory.PricingStrategyFactory;
import main.strategy.paymentStrategy.PaymentStrategy;
import main.strategy.pricingStrategy.PricingStrategy;

public class ExitGate {

    private final TicketManager ticketManager;

    public ExitGate(TicketManager ticketManager) {
        this.ticketManager = ticketManager;
    }

    public void processVehicleExit(int ticketId) throws Exception {
        Ticket ticket = ticketManager.getTicket(ticketId);
        if(ticket!=null) {
            double parkingPrice = calculateParkingPrice(ticket);
            System.out.println("Parking price for duration is "+parkingPrice);
            processPayment(parkingPrice);
            ticket.getParkingFloorAndParkingSlotVO().getParkingSlot().unParkVehicleFromParkingSlot();
        }
        else {
            throw new Exception("Invalid ticket id");
        }
    }

    private double calculateParkingPrice(Ticket ticket) {
        PricingStrategy pricingStrategy = PricingStrategyFactory.getPricingStrategy(PricingMethod.HOURLY_BASED);
        return ticket.getParkingFloorAndParkingSlotVO().getParkingSlot().price() * pricingStrategy.getPricing();
    }

    private void processPayment(double parkingFees) {
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(PaymentMethod.UPI);
        paymentStrategy.processPayment(parkingFees);
    }

}
