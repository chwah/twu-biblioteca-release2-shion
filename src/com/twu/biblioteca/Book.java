package com.twu.biblioteca;

/**
 * Created by shion on 13/04/2016.
 */
public class Book extends Medium {
    public Book(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    public String getAuthor() {
        return super.getCreator();
    }

    public String toString() {
        String str = "";
        str += "Title: " + getTitle() + ", ";
        str += "Author: " + getAuthor() + ", ";
        str += "Year Published: " + getYearPublished();
        return str;
    }
}
