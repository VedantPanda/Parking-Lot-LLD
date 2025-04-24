package main.factory;

import main.consts.PricingMethod;
import main.strategy.pricingStrategy.PricingStrategy;
import main.strategy.pricingStrategy.impl.HourlyBasedPricing;
import main.strategy.pricingStrategy.impl.MinuteBasedPricing;

public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(PricingMethod pricingMethod) {
        if(PricingMethod.HOURLY_BASED.equals(pricingMethod)) {
            return new HourlyBasedPricing();
        }
        else if(PricingMethod.MINUTELY_BASED.equals(pricingMethod)) {
            return new MinuteBasedPricing();
        }
        return null;
    }

}
