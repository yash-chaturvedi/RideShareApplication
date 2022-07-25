package com.lld.exception;

/**
 * @author Yash Chaturvedi
 */
public class VehicleExistsException extends RuntimeException{

    public VehicleExistsException(String msg) {
        super(msg);
    }
}
