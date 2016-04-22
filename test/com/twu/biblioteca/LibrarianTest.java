package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shion on 21/4/16.
 */
public class LibrarianTest {
    @Test
    public void librarianIsValid() {
        Librarian librarian = new Librarian("123-4567", "password");
        assertTrue(librarian.isValidLibrarian() == true);
    }

    @Test
    public void librarianIsNotValid() {
        Librarian librarian = new Librarian("123-45678", "password");
        assertTrue(librarian.isValidLibrarian() == false);
    }
}