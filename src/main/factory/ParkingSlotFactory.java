package main.factory;

import main.consts.VehicleType;
import main.entities.ParkingSlot.FourWheelerParkingSlot;
import main.entities.ParkingSlot.ParkingSlot;
import main.entities.ParkingSlot.SixWheelerParkingSlot;
import main.entities.ParkingSlot.TwoWheelerParkingSlot;

public class ParkingSlotFactory {

    public static ParkingSlot getParkingSlot(int id, VehicleType vehicleType){
        if(VehicleType.TWO_WHEELER.equals(vehicleType)){
            return new TwoWheelerParkingSlot(id);
        }
        else if(VehicleType.FOUR_WHEELER.equals(vehicleType)){
            return new FourWheelerParkingSlot(id);
        }
        else if(VehicleType.SIX_WHEELER.equals(vehicleType)){
            return new SixWheelerParkingSlot(id);
        }
        else {
            return null;
        }
    }

}
