package com.murli;


import com.murli.model.*;

import java.util.Map;
import java.util.Scanner;

public class ParkingAppTest {
    public static void main(String[] args) {
        // Create a test parking lot with 2 floors and 2 spaces per floor for each vehicle type
        ParkingLot testParkingLot = new ParkingLot(2, 2, createTestCostStrategy());

        // Test Case 1: Add two cars to the parking lot
        System.out.println("Test Case 1: Add two cars to the parking lot");
        addTestVehicle(testParkingLot, "AB12W5453", "Blue", VehicleType.CAR);
        addTestVehicle(testParkingLot, "XY45Z5456", "Red", VehicleType.CAR);

        // Test Case 2: Try adding a third car (should print an error message)
        System.out.println("\nTest Case 2: Try adding a third car (should print an error message)");
        addTestVehicle(testParkingLot, "MP12W5445", "Green", VehicleType.CAR);

        // Test Case 3: Remove the first car from the parking lot
        System.out.println("\nTest Case 3: Remove the first car from the parking lot");
        removeTestVehicle(testParkingLot, "AB12W5453", 2);

        // Test Case 4: Check availability of car spaces on floor 1
        System.out.println("\nTest Case 4: Check availability of car spaces on floor 1");
        checkAvailabilityTest(testParkingLot, 1, VehicleType.CAR);

        // Test Case 5: Check availability of bike spaces on floor 1
        System.out.println("\nTest Case 5: Check availability of bike spaces on floor 1");
        checkAvailabilityTest(testParkingLot, 1, VehicleType.BIKE);
    }

    private static CostStrategy createTestCostStrategy() {
        // Set up a test cost strategy with some hourly rates
        // Adjust rates based on your specific requirements
        return new CostStrategy(Map.of(
                VehicleType.BIKE, 10.0,
                VehicleType.CAR, 20.0,
                VehicleType.SPORTS_CAR, 30.0,
                VehicleType.TRUCK, 40.0,
                VehicleType.BUS, 50.0
        ), Currency.INR);
    }

    private static void addTestVehicle(ParkingLot parkingLot, String regNumber, String color, VehicleType type) {
        System.out.println("Adding vehicle: " + regNumber + " - " + color + " - " + type);
        Vehicle testVehicle = new Vehicle(regNumber, color, type);
        String ans = parkingLot.addVehicle(testVehicle);
        System.out.println(ans);

    }

    private static void removeTestVehicle(ParkingLot parkingLot, String regNumber, int hoursParked) {
        System.out.println("Removing vehicle: " + regNumber);
        String ans = parkingLot.removeVehicle(regNumber, hoursParked);
        System.out.println(ans);
    }

    private static void checkAvailabilityTest(ParkingLot parkingLot, int floorNumber, VehicleType vehicleType) {
        System.out.println("Checking availability on floor " + floorNumber + " for " + vehicleType);
        if (parkingLot.checkAvailability(floorNumber, vehicleType)) {
            System.out.println("Parking spaces available on floor " + floorNumber + " for " + vehicleType);
        } else {
            System.out.println("No parking spaces available on floor " + floorNumber + " for " + vehicleType);
        }
    }
}
