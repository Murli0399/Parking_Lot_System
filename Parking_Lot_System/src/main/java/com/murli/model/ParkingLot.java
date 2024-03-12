package com.murli.model;
import com.murli.enums.Currency;
import com.murli.enums.VehicleType;
import com.murli.exceptions.ParkingLotException;
import com.murli.interfaces.ParkingLotInter;

import java.util.*;
public class ParkingLot implements ParkingLotInter {
    private Map<Integer, Floor> floors; // Map to store floors in the parking lot
    private CostStrategy costStrategy; // Strategy for calculating parking fees

    // Constructor to initialize the parking lot with specified parameters
    public ParkingLot(int totalFloors, int capacityPerFloor, CostStrategy costStrategy) {
        this.floors = new HashMap<>();
        this.costStrategy = costStrategy;

        // Initialize floors with given capacity
        for (int i = 1; i <= totalFloors; i++) {
            floors.put(i, new Floor(i, capacityPerFloor));
        }
    }

    // Default constructor
    public ParkingLot() {
    }

    // Method to add a vehicle to the parking lot
    @Override
    public String addVehicle(Vehicle vehicle) {
        // Iterate through floors to find available space
        for (Floor floor : floors.values()) {
            if (floor.parkVehicle(vehicle)) {
                return "Vehicle parked successfully with registration number : " + vehicle.getRegistrationNumber();
            }
        }
        return "Parking lot is full. Sorry!";
    }

    // Method to remove a vehicle from the parking lot
    @Override
    public String removeVehicle(String registrationNumber, int hoursParked) {
        // Iterate through floors to find and remove the vehicle
        for (Floor floor : floors.values()) {
            VehicleType output = floor.removeVehicle(registrationNumber);
            if (output != VehicleType.DUMMY) {
                // Calculate parking fee using the provided cost strategy
                double fee = costStrategy.calculateFee(
                        floor.getAvailableSpaces(output).get(0).getType(),
                        hoursParked
                );
                Currency currency = costStrategy.getCurrency();
                return "Vehicle with registration number " + registrationNumber +
                        " removed. Parking Fee: " + fee + " " + currency;
            }
        }
        return "Vehicle not found with registration number: " + registrationNumber + " or invalid registration number.";
    }

    // Method to check the availability of parking spaces on a specific floor for a given vehicle type
    public boolean checkAvailability(int floorNumber, VehicleType type) {
        Floor floor = floors.get(floorNumber);
        if (floor != null) {
            return !floor.getAvailableSpaces(type).isEmpty();
        }
        return false;
    }
}

