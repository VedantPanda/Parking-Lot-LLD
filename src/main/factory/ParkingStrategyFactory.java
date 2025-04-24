package main.factory;

import main.consts.ParkingMethod;
import main.strategy.parkingstrategy.ParkingStrategy;
import main.strategy.parkingstrategy.impl.NormalParkingStrategy;

public class ParkingStrategyFactory {

    public static ParkingStrategy getParkingStrategy(ParkingMethod parkingMethod) {
        if(ParkingMethod.NORMAL_PARKING.equals(parkingMethod)) {
            return new NormalParkingStrategy();
        }
        return null;
    }

}
