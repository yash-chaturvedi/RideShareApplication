package com.lld.exception;

/**
 * @author Yash Chaturvedi
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
