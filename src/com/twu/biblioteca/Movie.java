package com.twu.biblioteca;

/**
 * Created by shion on 19/4/16.
 */
public class Movie {
    private String title;
    private String director;
    private int yearPublished;
    private int rating;
    private boolean checkedOut;

    public Movie(String title, String director, int yearPublished, int rating) {
        this.title = title;
        this.director = director;
        this.yearPublished = yearPublished;
        this.rating = rating;
        this.checkedOut = false;
    }
}
