package com.lld.dao;

import com.lld.exception.RideExistsException;
import com.lld.exception.RideNotFoundException;
import com.lld.model.Ride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Yash Chaturvedi
 */
public class RideManager {

    private final Map<String, Ride> activeRides;
    private final List<Ride> completedRides;

    public RideManager() {
        this.activeRides = new HashMap<>();
        this.completedRides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        if(activeRides.containsKey(ride.getVehicle().getId())) {
            throw new RideExistsException("Ride already present for vehicle : "
                    + ride.getVehicle().getModel() + ", licensePlate : " + ride.getVehicle().getLicensePlate());
        }
        activeRides.put(ride.getVehicle().getId(), ride);
    }

    public void completeRide(Ride ride) {
        if(Objects.isNull(ride) || !activeRides.containsKey(ride.getVehicle().getId())) {
            throw new RideNotFoundException("Ride not found for vehicle : "
                    + ride.getVehicle().getModel() + ", licensePlate : " + ride.getVehicle().getLicensePlate());
        }
        ride = activeRides.remove(ride.getVehicle().getId());
        completedRides.add(ride);
    }

    public List<Ride> getActiveRides() {
        return new ArrayList<>(activeRides.values());
    }

    public List<Ride> getCompletedRides() {
        return completedRides;
    }
}
