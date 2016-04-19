package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shion on 19/4/16.
 */
public class MovieTest {
    @Test
    public void movieIsValid() {
        Movie movie = new Movie("Test Title", "Test Director", 2016, 10);
        assertTrue(movie.getTitle() == "Test Title");
        assertTrue(movie.getDirector() == "Test Director");
        assertTrue(movie.getYearPublished() == 2016);
        assertTrue(movie.getRating() == 10);
    }

    @Test
    public void movieIsAvailable() {
        Movie movie = new Movie("Test Title", "Test Director", 2016, 10);
        movie.setCheckedOut(true);
        assertTrue(movie.isAvailable() == false);
    }

    @Test
    public void movieIsNotAvailable() {
        Movie movie = new Movie("Test Title", "Test Director", 2016, 10);
        movie.setCheckedOut(false);
        assertTrue(movie.isAvailable() == true);
    }
}