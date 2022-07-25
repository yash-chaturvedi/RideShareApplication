package com.lld.service;

import com.lld.dao.UserManager;
import com.lld.dao.VehicleManager;
import com.lld.model.User;
import com.lld.model.Vehicle;

/**
 * @author Yash Chaturvedi
 */
public class VehicleService {

    private final VehicleManager vehicleManager;
    private final UserManager userManager;

    public VehicleService(VehicleManager vehicleManager, UserManager userManager) {
        this.vehicleManager = vehicleManager;
        this.userManager = userManager;
    }

    public void addVehicle(String userName, String model, String licensePlate) {
        try {
            User user = userManager.getUser(userName);
            Vehicle vehicle = new Vehicle(user, model, licensePlate);
            vehicleManager.addVehicle(vehicle);
            System.out.println("Vehicle " + licensePlate + " for user " + userName + " added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
