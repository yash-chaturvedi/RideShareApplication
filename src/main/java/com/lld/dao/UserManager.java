package com.lld.dao;

import com.lld.exception.UserExistsException;
import com.lld.exception.UserNotFoundException;
import com.lld.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yash Chaturvedi
 */
public class UserManager {

    private final Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        if(this.users.containsKey(user.getName())) {
            throw new UserExistsException("User already present for name : " + user.getName());
        }
        this.users.put(user.getName(), user);
    }

    public User getUser(String userName) {
        if(!this.users.containsKey(userName)) {
            throw new UserNotFoundException("Could not find user with name : " + userName);
        }
        return this.users.get(userName);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
