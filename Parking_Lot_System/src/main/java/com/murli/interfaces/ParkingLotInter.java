package com.murli.interfaces;

import com.murli.enums.VehicleType;
import com.murli.model.Vehicle;

public interface ParkingLotInter {
    public String addVehicle(Vehicle vehicle);
    public String removeVehicle(String registrationNumber, int hoursParked);
    public boolean checkAvailability(int floorNumber, VehicleType type);
}
