package com.lld.model;

import java.util.UUID;

/**
 * @author Yash Chaturvedi
 */
public class Vehicle {

    private final String id;
    private User driver;
    private String model;
    private String licensePlate;

    public Vehicle(User driver, String model, String licensePlate) {
        this.id = UUID.randomUUID().toString();
        this.driver = driver;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public String getId() {
        return id;
    }

    public User getDriver() {
        return driver;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}
