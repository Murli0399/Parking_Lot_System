package com.murli.interfaces;

import com.murli.model.Vehicle;

public interface VehicleSpaceInter {
    public void parkVehicle(Vehicle vehicle);
    public void removeVehicle();
    public boolean isAvailable();
}
