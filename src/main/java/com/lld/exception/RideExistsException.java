package com.lld.exception;

/**
 * @author Yash Chaturvedi
 */
public class RideExistsException extends RuntimeException{
    public RideExistsException(String msg) {
        super(msg);
    }
}
