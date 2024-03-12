package com.murli.model;

import com.murli.enums.VehicleType;
import com.murli.exceptions.ParkingLotException;

public class Vehicle {

    private String registrationNumber;
    private String color;
    private VehicleType type;

    public Vehicle(String registrationNumber, String color, VehicleType type) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new ParkingLotException("Registration number cannot be null or empty");
        }
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getType() {
        return type;
    }

}
