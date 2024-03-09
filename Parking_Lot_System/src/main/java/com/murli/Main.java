package com.murli;

import com.murli.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Method to display the parking lot menu
    private static void showMenu() {
        System.out.println("Parking Lot Menu:");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle");
        System.out.println("3. Check Availability");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to handle adding a vehicle to the parking lot
    private static void addVehicleOperation(Scanner sc, ParkingLot parkingLot) {
        System.out.println("Enter vehicle registration number: ");
        String registrationNumber = sc.next();
        System.out.println("Enter vehicle color: ");
        String color = sc.next();
        System.out.println("Enter vehicle type (BIKE, CAR, SPORTS_CAR, TRUCK, BUS): ");
        VehicleType type = VehicleType.valueOf(sc.next().toUpperCase());

        Vehicle vehicle = new Vehicle(registrationNumber, color, type);

        String output = parkingLot.addVehicle(vehicle);
        System.out.println(output);
    }

    // Method to handle removing a vehicle from the parking lot
    private static void removeVehicleOperation(Scanner sc, ParkingLot parkingLot) {
        System.out.println("Enter vehicle registration number to remove: ");
        String registrationNumber = sc.next();
        System.out.println("Enter hours parked: ");
        int hoursParked = sc.nextInt();

        String output = parkingLot.removeVehicle(registrationNumber, hoursParked);
        System.out.println(output);
    }

    // Method to check the availability of parking spaces for a specific vehicle type on a given floor
    private static void checkAvailabilityOperation(Scanner sc, ParkingLot parkingLot) {
        System.out.println("Enter floor number to check: ");
        int floorNumber = sc.nextInt();
        System.out.println("Enter vehicle type to check (BIKE, CAR, SPORTS_CAR, TRUCK, BUS): ");
        VehicleType vehicleType = VehicleType.valueOf(sc.next().toUpperCase());

        if (parkingLot.checkAvailability(floorNumber, vehicleType)) {
            System.out.println("Parking spaces available on floor " + floorNumber + " for " + vehicleType);
        } else {
            System.out.println("No parking spaces available on floor " + floorNumber + " for " + vehicleType);
        }

    }


    public static void main(String[] args) {


        // Setting up hourly parking rates for each vehicle type in INR
        Map<VehicleType, Double> hourlyRates = new HashMap<>();
        hourlyRates.put(VehicleType.BIKE, 10.0);
        hourlyRates.put(VehicleType.CAR, 20.0);
        hourlyRates.put(VehicleType.SPORTS_CAR, 30.0);
        hourlyRates.put(VehicleType.TRUCK, 40.0);
        hourlyRates.put(VehicleType.BUS, 50.0);

        // Creating a cost strategy with hourly rates and currency
        CostStrategy costStrategy = new CostStrategy(hourlyRates, Currency.INR);

        // Initializing the parking lot with 2 floors and 2 vehicle spaces per floor for each vehicle type
        ParkingLot parkingLot = new ParkingLot(2, 2, costStrategy);

        // Creating a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        String choice;

        // Main menu loop for user interaction
        do {
            showMenu();
            choice = sc.next();

            switch (choice) {
                case "1":
                    addVehicleOperation(sc, parkingLot);
                    break;
                case "2":
                    removeVehicleOperation(sc, parkingLot);
                    break;
                case "3":
                    checkAvailabilityOperation(sc, parkingLot);
                    break;
                case "0":
                    System.out.println("Thank you for using our Parking Lot Application");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("0"));

        sc.close();
    }
}