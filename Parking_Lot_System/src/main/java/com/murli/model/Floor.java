package com.murli.model;

import java.util.*;

public class Floor {
    private int floorNumber; // Floor number identifier
    private Map<VehicleType, List<VehicleSpace>> vehicleSpaces; // Map to store vehicle spaces by type

    // Constructor to initialize the floor with specified floor number and capacity per type
    public Floor(int floorNumber, int capacityPerType) {
        this.floorNumber = floorNumber;
        this.vehicleSpaces = new HashMap<>();

        // Initialize vehicle spaces for each type
        for (VehicleType type : VehicleType.values()) {
            List<VehicleSpace> spaces = new ArrayList<>();
            for (int i = 1; i <= capacityPerType; i++) {
                spaces.add(new VehicleSpace(i, type));
            }
            vehicleSpaces.put(type, spaces);
        }
    }

    // Method to get available parking spaces for a specific vehicle type
    public List<VehicleSpace> getAvailableSpaces(VehicleType type) {
        return vehicleSpaces.get(type).stream().filter(VehicleSpace::isAvailable).toList();
    }

    // Method to park a vehicle in an available space of the specified type
    public boolean parkVehicle(Vehicle vehicle) {
        List<VehicleSpace> spaces = getAvailableSpaces(vehicle.getType());
        if (!spaces.isEmpty()) {
            VehicleSpace space = spaces.get(0);
            space.parkVehicle(vehicle);
            return true;
        }
        return false; // No available space for the specified vehicle type
    }

    // Method to remove a vehicle from the floor based on registration number
    public VehicleType removeVehicle(String registrationNumber) {
        for (List<VehicleSpace> spaces : vehicleSpaces.values()) {
            for (VehicleSpace space : spaces) {
                if (!space.isAvailable() && space.getParkedVehicle().getRegistrationNumber().equals(registrationNumber)) {
                    VehicleType returnVehicleType = space.getParkedVehicle().getType();
                    space.removeVehicle(); // Remove the vehicle from the space
                    return returnVehicleType; // Return the type of removed vehicle
                }
            }
        }
        return VehicleType.DUMMY; // Return DUMMY type if the vehicle is not found
    }
}

