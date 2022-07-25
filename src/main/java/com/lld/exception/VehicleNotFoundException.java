package com.lld.exception;

/**
 * @author Yash Chaturvedi
 */
public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(String msg) {
        super(msg);
    }
}
