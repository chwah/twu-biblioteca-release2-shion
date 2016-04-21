package com.twu.biblioteca;

/**
 * Created by shion on 19/4/16.
 */
public abstract class Medium {
    private String title;
    private String creator;
    private int yearPublished;
    private boolean checkedOut;

    public Medium(String title, String creator, int yearPublished) {
        this.title = title;
        this.creator = creator;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
    }

    protected String getTitle() {
        return title;
    }

    protected String getCreator() {
        return creator;
    }

    protected int getYearPublished() {
        return yearPublished;
    }

    protected void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    protected boolean isAvailable() {
        return !checkedOut;
    }

    protected boolean isValid() {
        if (getTitle().length() > 0 && getCreator().length() > 0 && getYearPublished() > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = "";
        str += "Title: " + getTitle() + ", ";
        str += "Creator: " + getCreator() + ", ";
        str += "Year Published: " + getYearPublished() + ", ";
        return str;
    }
}
