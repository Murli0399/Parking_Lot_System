package com.murli;


import com.murli.enums.Currency;
import com.murli.enums.VehicleType;
import com.murli.interfaceImpl.*;

import java.util.Map;

public class ParkingAppTest {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2,2,new CostStrategy(Map.of(VehicleType.CAR,20.0),Currency.INR));

    }
}
