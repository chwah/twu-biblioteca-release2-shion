package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by shion on 21/4/16.
 */
abstract public class User {
    private String id;
    private String password;
    private ArrayList<Medium> checkedOutItems;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        checkedOutItems = new ArrayList<Medium>();
    }

    public String getId() {
        return id;
    }

    protected String getPassword() {
        return password;
    }

    public ArrayList<Medium> getCheckedOutItems() {
        return checkedOutItems;
    }

    public boolean isValidUser() {
        String pattern = "^\\d{3}-\\d{4}$";
        return getId().matches(pattern);
    }

    public Medium addCheckedOutItems(Medium medium) {
        getCheckedOutItems().add(medium);
        return medium;
    }

    public boolean removeCheckedOutItems(Medium medium) {
        return getCheckedOutItems().remove(medium);
    }

    public boolean hasCheckedOutItem(Medium medium) {
        return getCheckedOutItems().contains(medium);
    }
}
