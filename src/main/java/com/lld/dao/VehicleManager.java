package com.lld.dao;

import com.lld.exception.VehicleExistsException;
import com.lld.exception.VehicleNotFoundException;
import com.lld.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yash Chaturvedi
 */
public class VehicleManager {

    private final Map<String, Vehicle> vehicles;

    public VehicleManager() {
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if(this.vehicles.containsKey(vehicle.getLicensePlate())) {
            throw new VehicleExistsException("Vehicle already present with licensePlate : " + vehicle.getLicensePlate());
        }
        this.vehicles.put(vehicle.getLicensePlate(), vehicle);
    }

    public Vehicle getVehicle(String licensePlate) {
        if(!this.vehicles.containsKey(licensePlate)) {
            throw new VehicleNotFoundException("Could not find vehicle with licensePlate : " + licensePlate);
        }
        return this.vehicles.get(licensePlate);
    }
}
