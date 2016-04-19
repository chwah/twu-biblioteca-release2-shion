package com.twu.biblioteca;

/**
 * Created by shion on 19/4/16.
 */
public class Movie extends Medium {
    private int rating;


    public Movie(String title, String director, int yearPublished, int rating) {
        super(title, director, yearPublished);
        this.rating = rating;
    }

    public String getDirector() {
        return super.getCreator();
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        String str = "";
        str += "Title: " + getTitle() + ", ";
        str += "Author: " + getDirector() + ", ";
        str += "Year Published: " + getYearPublished() + ", ";
        str += "Rating: " + (getRating() == 0 ? "unrated" : String.valueOf(getRating()));
        return str;
    }
}
