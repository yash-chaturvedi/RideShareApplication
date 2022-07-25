package com.lld.exception;

/**
 * @author Yash Chaturvedi
 */
public class UserExistsException extends RuntimeException{

    public UserExistsException(String msg) {
        super(msg);
    }
}
