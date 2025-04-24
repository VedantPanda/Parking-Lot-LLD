package main.factory;

import main.consts.PaymentMethod;
import main.strategy.paymentStrategy.PaymentStrategy;
import main.strategy.paymentStrategy.impl.CreditCard;
import main.strategy.paymentStrategy.impl.DebitCard;
import main.strategy.paymentStrategy.impl.Upi;

public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentMethod paymentStrategy) {
        if(PaymentMethod.UPI.equals(paymentStrategy)) {
            return new Upi();
        }
        else if(PaymentMethod.CREDIT_CARD.equals(paymentStrategy)) {
            return new CreditCard();
        }
        else if(PaymentMethod.DEBIT_CARD.equals(paymentStrategy)) {
            return new DebitCard();
        }
        return null;
    }

}
