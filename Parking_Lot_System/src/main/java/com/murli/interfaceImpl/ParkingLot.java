package com.murli.interfaceImpl;
import com.murli.enums.Currency;
import com.murli.enums.VehicleType;
import com.murli.interfaces.ParkingLotInter;

import java.time.Duration;
import java.time.LocalDateTime;
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
                return "Vehicle parked successfully with token number : " + vehicle.getToken();
            }
        }
        return "Parking lot is full. Sorry!";
    }

    // Method to remove a vehicle from the parking lot
    @Override
    public String removeVehicle(String token) {
        // Iterate through floors to find and remove the vehicle
        for (Floor floor : floors.values()) {
            Vehicle output = floor.removeVehicle(token);
            if (output.getToken().equals(token)) {

                Duration duration = Duration.between(output.getLocalDateTime(), LocalDateTime.now());
                int hoursParked = (int) Math.ceil(duration.toMillis() / (60.0 * 60 * 1000));

                // Calculate parking fee using the provided cost strategy
                double fee = costStrategy.calculateFee(
                        floor.getAvailableSpaces(output.getType()).get(0).getType(),
                        hoursParked
                );
                Currency currency = costStrategy.getCurrency();
                return "Vehicle with token number " + token +
                        " removed. Parking Fee: " + fee + " " + currency;
            }
        }
        return "Vehicle not found with token number: " + token + " or invalid token.";
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

