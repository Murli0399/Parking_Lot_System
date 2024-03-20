package com.murli.interfaces;

import com.murli.interfaceImpl.Vehicle;

public interface VehicleSpaceInter {
    public void parkVehicle(Vehicle vehicle);
    public void removeVehicle();
    public boolean isAvailable();
}
