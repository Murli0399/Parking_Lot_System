package com.murli.interfaceImpl;

import com.murli.enums.VehicleType;
import com.murli.exceptions.ParkingLotException;

import java.time.LocalDateTime;

public class Vehicle {

    private String registrationNumber;
    private String color;
    private VehicleType type;
    private LocalDateTime localDateTime;
    private String token;

    public Vehicle(String registrationNumber, String color, VehicleType type, LocalDateTime localDateTime) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new ParkingLotException("Registration number cannot be null or empty");
        }
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
        this.localDateTime = localDateTime;
    }

    public Vehicle() {
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

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                ", localDateTime=" + localDateTime +
                ", token='" + token + '\'' +
                '}';
    }
}
