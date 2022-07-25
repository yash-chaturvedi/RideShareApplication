package com.lld.model;

import com.lld.exception.RideNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Yash Chaturvedi
 */
public class PreferredVehiclePolicy implements RideSelectionPolicy {

    private String preferredVehicleModel;

    public PreferredVehiclePolicy(String preferredVehicleModel) {
        this.preferredVehicleModel = preferredVehicleModel;
    }

    public void setPreferredVehicleModel(String preferredVehicleModel) {
        this.preferredVehicleModel = preferredVehicleModel;
    }

    @Override
    public Ride getRide(String origin, String destination, int seats, List<Ride> rides) {
        Predicate<Ride> predicate = r -> r.getDestination().equals(destination)
                && r.getOrigin().equals(origin)
                && r.getAvailableSeats()>=seats
                && Objects.isNull(r.getPassenger());

        return rides.stream()
                .filter(predicate)
                .filter(r -> preferredVehicleModel.equalsIgnoreCase(r.getVehicle().getModel()))
                .findFirst()
                .orElseThrow(RideNotFoundException::new);
    }

}
