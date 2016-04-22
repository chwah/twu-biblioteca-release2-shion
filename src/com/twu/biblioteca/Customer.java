package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by shion on 21/4/16.
 */
public class Customer extends User {
    private String name;
    private String email;
    private String phoneNumber;

    public Customer (String id, String password, String name, String email, String phoneNumber) {
        super(id, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isValidCustomer() {
        return super.isValidUser() && hasValidEmail() && hasPhoneNumber();
    }

    private boolean hasValidEmail() {
        String pattern = "^[\\w\\d+_.-]+@(.+)$";
        return getEmail().matches(pattern);
    }

    private boolean hasPhoneNumber() {
        String pattern = "^\\d{8}$";
        return getPhoneNumber().matches(pattern);
    }

    public String toString() {
        String str = "";
        str += "Name: " + getName() + ", ";
        str += "Email: " + getEmail() + ", ";
        str += "Phone Number: " + getPhoneNumber();
        return str;
    }
}
