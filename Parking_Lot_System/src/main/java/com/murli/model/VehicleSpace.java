package com.murli.model;

public class VehicleSpace {
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

    // Method to park a vehicle in the space
    public void parkVehicle(Vehicle vehicle) {
        this.available = false; // The space is now occupied
        this.parkedVehicle = vehicle; // Set the parked vehicle reference
    }

    // Method to remove a vehicle from the space
    public void removeVehicle() {
        this.available = true; // The space is now available
        this.parkedVehicle = null; // Clear the parked vehicle reference
    }

    // Method to check if the space is available
    public boolean isAvailable() {
        return available;
    }

    // Getter method to retrieve the type of vehicle the space is designed for
    public VehicleType getType() {
        return type;
    }

    // Getter method to retrieve the reference to the parked vehicle
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}

