package com.lld.service;

import com.lld.dao.UserManager;
import com.lld.model.User;

/**
 * @author Yash Chaturvedi
 */
public class UserService {

    private final UserManager userManager;

    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public void addUser(String name, String gender, int age) {
        try {
            User user= new User(name, gender, age);
            userManager.addUser(user);
            System.out.println("User "+ name + " added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
