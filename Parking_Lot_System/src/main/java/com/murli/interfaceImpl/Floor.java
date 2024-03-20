package com.murli.interfaceImpl;

import com.murli.enums.VehicleType;
import com.murli.exceptions.ParkingLotException;
import com.murli.interfaces.FloorInter;

import java.util.*;

public class Floor implements FloorInter {
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
    @Override
    public List<VehicleSpace> getAvailableSpaces(VehicleType type) {
        if (!vehicleSpaces.containsKey(type)) {
            throw new ParkingLotException("Invalid vehicle type: " + type);
        }
        return vehicleSpaces.get(type).stream().filter(VehicleSpace::isAvailable).toList();
    }

    // Method to park a vehicle in an available space of the specified type
    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        List<VehicleSpace> spaces = getAvailableSpaces(vehicle.getType());
        if (!spaces.isEmpty()) {
            VehicleSpace space = spaces.get(0);
            vehicle.setToken("F"+this.floorNumber+"S"+space.getSpaceNumber()+vehicle.getType());
            space.parkVehicle(vehicle);
            return true;
        }
        return false; // No available space for the specified vehicle type
    }

    // Method to remove a vehicle from the floor based on registration number
    @Override
    public Vehicle removeVehicle(String token) {
        for (List<VehicleSpace> spaces : vehicleSpaces.values()) {
            for (VehicleSpace space : spaces) {
                if (!space.isAvailable() && space.getParkedVehicle().getToken().equals(token)) {
                    Vehicle returnVehicle = space.getParkedVehicle();
                    space.removeVehicle(); // Remove the vehicle from the space
                    return returnVehicle; // Return the type of removed vehicle
                }
            }
        }
        return new Vehicle();
    }
}

