package com.murli.interfaces;

import com.murli.enums.VehicleType;
import com.murli.interfaceImpl.Vehicle;

public interface ParkingLotInter {
    public String addVehicle(Vehicle vehicle);
    public String removeVehicle(String registrationNumber);
    public boolean checkAvailability(int floorNumber, VehicleType type);
}
