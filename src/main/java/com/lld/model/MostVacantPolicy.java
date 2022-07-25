package com.lld.model;

import com.lld.exception.RideNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Yash Chaturvedi
 */
public class MostVacantPolicy implements RideSelectionPolicy {

    @Override
    public Ride getRide(String origin, String destination, int seats, List<Ride> rides) {
        Predicate<Ride> predicate = r -> r.getDestination().equals(destination)
                && r.getOrigin().equals(origin)
                && r.getAvailableSeats()>=seats
                && Objects.isNull(r.getPassenger());

        return rides.stream()
                .filter(predicate)
                .min((r1, r2) -> r2.getAvailableSeats() - r1.getAvailableSeats())
                .orElseThrow(RideNotFoundException::new);
    }
}
