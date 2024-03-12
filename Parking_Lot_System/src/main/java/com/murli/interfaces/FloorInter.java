package com.murli.interfaces;

import com.murli.enums.VehicleType;
import com.murli.model.Vehicle;
import com.murli.model.VehicleSpace;

import java.util.List;

public interface FloorInter {
    public List<VehicleSpace> getAvailableSpaces(VehicleType type);
    public boolean parkVehicle(Vehicle vehicle);
    public VehicleType removeVehicle(String registrationNumber);
}
