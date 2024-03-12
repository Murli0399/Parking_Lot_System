package com.murli.interfaces;

import com.murli.enums.VehicleType;
import com.murli.exceptions.ParkingLotException;

public interface CostStrategyInter {
    public double calculateFee(VehicleType type, int hours) throws ParkingLotException;
}
