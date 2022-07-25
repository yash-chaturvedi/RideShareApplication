package com.lld.exception;

/**
 * @author Yash Chaturvedi
 */
public class RideNotFoundException extends RuntimeException{

    public RideNotFoundException(String msg) {
        super(msg);
    }

    public RideNotFoundException() {
        super("Ride not found");
    }
}
