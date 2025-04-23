package main.strategy.paymentStrategy.impl;

import main.strategy.paymentStrategy.PaymentStrategy;

public class CreditCard implements PaymentStrategy {
    @Override
    public void processPayment(double price) {
        System.out.println("Price "+price+" is successful using credit card");
    }
}
