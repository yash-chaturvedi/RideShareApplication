package com.lld.model;

import java.util.UUID;

/**
 * @author Yash Chaturvedi
 */
public class Ride {

    private final String id;
    private Vehicle vehicle;
    private String origin;
    private String destination;
    private int availableSeats;
    private User passenger;

    public Ride(Vehicle vehicle, String origin, String destination, int availableSeats) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getOrigin() {
        return origin;
    }

    public User getPassenger() {
        return passenger;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }
}
