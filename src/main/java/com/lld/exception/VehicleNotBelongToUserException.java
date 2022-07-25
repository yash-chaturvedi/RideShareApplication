package com.lld.exception;

/**
 * @author Yash Chaturvedi
 */
public class VehicleNotBelongToUserException extends RuntimeException{

    public VehicleNotBelongToUserException(String msg) {
        super(msg);
    }
}
