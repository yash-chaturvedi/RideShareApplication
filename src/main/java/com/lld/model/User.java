package com.lld.model;

import java.util.UUID;

/**
 * @author Yash Chaturvedi
 */
public class User {

    private final String id;
    private String name;
    private String gender;
    private int age;

    public User(String name, String gender, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
