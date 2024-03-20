package com.murli.interfaces;

import com.murli.enums.VehicleType;
import com.murli.interfaceImpl.Vehicle;
import com.murli.interfaceImpl.VehicleSpace;

import java.util.List;

public interface FloorInter {
    public List<VehicleSpace> getAvailableSpaces(VehicleType type);
    public boolean parkVehicle(Vehicle vehicle);
    public Vehicle removeVehicle(String registrationNumber);
}
