package com.lld.service;

import com.lld.dao.RideManager;
import com.lld.dao.UserManager;
import com.lld.dao.VehicleManager;
import com.lld.exception.VehicleNotBelongToUserException;
import com.lld.model.Ride;
import com.lld.model.User;
import com.lld.model.Vehicle;
import com.lld.model.RideSelectionPolicy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Yash Chaturvedi
 */
public class RideShareService {

    private final UserManager userManager;
    private final RideManager rideManager;
    private final VehicleManager vehicleManager;

    public RideShareService(UserManager userManager, RideManager rideManager, VehicleManager vehicleManager) {
        this.userManager = userManager;
        this.rideManager = rideManager;
        this.vehicleManager = vehicleManager;
    }

    public Ride offerRide(String userName, String origin,
                           int availableSeats, String vehicleModel, String licensePlate, String destination) {

        try {
            User user = userManager.getUser(userName);
            Vehicle vehicle = vehicleManager.getVehicle(licensePlate);

            if(!user.equals(vehicle.getDriver())) {
                throw new VehicleNotBelongToUserException("Vehicle with licensePlate : " + vehicle.getLicensePlate()
                        + " does not belong to user : " + user.getName());
            }

            Ride ride = new Ride(vehicle, origin, destination, availableSeats);
            rideManager.addRide(ride);

            System.out.println("Ride offered by " + userName + " from " + origin + " to " + destination +
                    ". Available Seats " + availableSeats + " vehicle : " + vehicleModel + " licensePlate " + licensePlate);
            return ride;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Ride selectRide(String userName, String origin, String destination, int seats,
                           RideSelectionPolicy rideSelectionPolicy) {

        try {
            User user = userManager.getUser(userName);
            List<Ride> rides = rideManager.getActiveRides();
            Ride ride = rideSelectionPolicy.getRide(origin, destination, seats, rides);
            ride.setPassenger(user);
            System.out.println(userName + " takes a ride from " + origin + " to " + destination
                    + ". Vehicle : " + ride.getVehicle().getModel()
                    + " licensePlate " + ride.getVehicle().getLicensePlate());
            return ride;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void endRide(Ride ride) {
        try {
            rideManager.completeRide(ride);
            System.out.println("Completed ride for vehicle " + ride.getVehicle().getModel()
                    + " licensePlate " + ride.getVehicle().getLicensePlate());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printRideStats() {
        Map<String, Integer> userToRidesOfferedCnt = new HashMap<>();
        Map<String, Integer> userToRidesTakenCnt = new HashMap<>();

        List<User> users = userManager.getAllUsers();
        for (User u : users) {
            userToRidesOfferedCnt.put(u.getName(), 0);
            userToRidesTakenCnt.put(u.getName(), 0);
        }

        List<Ride> completedRides = rideManager.getCompletedRides();
        for(Ride r : completedRides) {
            Integer ridesOfferedCnt = userToRidesOfferedCnt.get(r.getVehicle().getDriver().getName());
            userToRidesOfferedCnt.put(r.getVehicle().getDriver().getName(), ridesOfferedCnt + 1);

            if(Objects.nonNull(r.getPassenger())) {
                Integer ridesTakenCnt = userToRidesTakenCnt.get(r.getPassenger().getName());
                userToRidesTakenCnt.put(r.getPassenger().getName(), ridesTakenCnt + 1);
            }
        }

        users.forEach(u -> {
            System.out.println(u.getName() + " : " + userToRidesTakenCnt.get(u.getName()) + " Taken, "
                    + userToRidesOfferedCnt.get(u.getName()) + " Offered");
        });
    }
}
