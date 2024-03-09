package com.murli.model;

import java.util.Map;

public class CostStrategy {
    private Map<VehicleType, Double> hourlyRates; // Hourly rates for different vehicle types
    private Currency currency; // Currency used for fee representation

    // Constructor to initialize the cost strategy with hourly rates and currency
    public CostStrategy(Map<VehicleType, Double> hourlyRates, Currency currency) {
        this.hourlyRates = hourlyRates;
        this.currency = currency;
    }

    // Method to calculate the parking fee for a given vehicle type and hours parked
    public double calculateFee(VehicleType type, int hours) {
        double hourlyRate = hourlyRates.get(type);
        return hourlyRate * hours; // Simple calculation: hourly rate multiplied by hours parked
    }

    // Getter method to retrieve the currency used for fee representation
    public Currency getCurrency() {
        return currency;
    }
}

