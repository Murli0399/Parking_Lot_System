package com.murli.model;

import com.murli.enums.Currency;
import com.murli.enums.VehicleType;
import com.murli.exceptions.ParkingLotException;
import com.murli.interfaces.CostStrategyInter;

import java.util.Map;

public class CostStrategy implements CostStrategyInter {
    private Map<VehicleType, Double> hourlyRates; // Hourly rates for different vehicle types
    private Currency currency; // Currency used for fee representation

    // Constructor to initialize the cost strategy with hourly rates and currency
    public CostStrategy(Map<VehicleType, Double> hourlyRates, Currency currency) {
        this.hourlyRates = hourlyRates;
        this.currency = currency;
    }

    // Method to calculate the parking fee for a given vehicle type and hours parked
    @Override
    public double calculateFee(VehicleType type, int hours) throws ParkingLotException {
        if (!hourlyRates.containsKey(type)) {
            throw new ParkingLotException("Hourly rate not defined for vehicle type: " + type);
        }
        double hourlyRate = hourlyRates.get(type);
        return hourlyRate * hours; // Simple calculation: hourly rate multiplied by hours parked
    }

    // Getter method to retrieve the currency used for fee representation
    public Currency getCurrency() {
        return currency;
    }
}

