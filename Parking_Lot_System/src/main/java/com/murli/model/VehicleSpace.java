package com.murli.model;

import com.murli.enums.VehicleType;
import com.murli.interfaces.VehicleSpaceInter;

public class VehicleSpace implements VehicleSpaceInter {
    private int spaceNumber;
    private boolean available;
    private VehicleType type;
    private Vehicle parkedVehicle;

    // Constructor to initialize the vehicle space with a space number and vehicle type
    public VehicleSpace(int spaceNumber, VehicleType type) {
        this.spaceNumber = spaceNumber;
        this.available = true; // Initially, the space is available
        this.type = type;
    }


    // Getter method to retrieve the type of vehicle the space is designed for
    public VehicleType getType() {
        return type;
    }

    // Getter method to retrieve the reference to the parked vehicle
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }



    // Method to park a vehicle in the space
    @Override
    public void parkVehicle(Vehicle vehicle) {
        this.available = false; // The space is now occupied
        this.parkedVehicle = vehicle; // Set the parked vehicle reference
    }

    // Method to remove a vehicle from the space
    @Override
    public void removeVehicle() {
        this.available = true; // The space is now available
        this.parkedVehicle = null; // Clear the parked vehicle reference
    }

    // Method to check if the space is available
    @Override
    public boolean isAvailable() {
        return available;
    }
}

