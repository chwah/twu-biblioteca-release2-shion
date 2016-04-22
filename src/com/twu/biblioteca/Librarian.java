package com.twu.biblioteca;

/**
 * Created by shion on 21/4/16.
 */
public class Librarian extends User {
    public Librarian (String id, String password) {
        super(id, password);
    }

    public boolean isValidLibrarian() {
        return super.isValidUser();
    }
}
