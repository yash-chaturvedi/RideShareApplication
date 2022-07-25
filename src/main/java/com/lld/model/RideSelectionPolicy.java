package com.lld.model;

import java.util.List;

/**
 * @author Yash Chaturvedi
 */
public interface RideSelectionPolicy {

    Ride getRide(String origin, String destination, int seats, List<Ride> rides);
}
