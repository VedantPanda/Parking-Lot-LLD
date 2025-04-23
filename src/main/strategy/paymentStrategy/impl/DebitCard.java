package main.strategy.paymentStrategy.impl;

import main.strategy.paymentStrategy.PaymentStrategy;

public class DebitCard implements PaymentStrategy {
    @Override
    public void processPayment(double price) {
        System.out.println("Price "+price+" is successful using Debit card");
    }
}
