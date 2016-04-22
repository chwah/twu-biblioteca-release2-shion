package com.twu.biblioteca;

/**
 * Created by shion on 21/4/16.
 */
public class LibraryUI {

    public static String mainMenuLibrarian() {
        String str = "";
        str += "1. List Books\n";
        str += "2. List Books with Details\n";
        str += "3. List Movies\n";
        str += "4. Checkout Book\n";
        str += "5. Checkout Movie\n";
        str += "6. Return Book\n";
        str += "7. Return Movie\n";
        str += "8. List All Users with Checked Out Books\n";
        str += "0. Quit\n\n";
        str += "Input: ";
        return str;
    }

    public static String mainMenuCustomer() {
        String str = "";
        str += "1. List Books\n";
        str += "2. List Books with Details\n";
        str += "3. List Movies\n";
        str += "4. Checkout Book\n";
        str += "5. Checkout Movie\n";
        str += "6. Return Book\n";
        str += "7. Return Movie\n";
        str += "8. Show User Information\n";
        str += "0. Quit\n\n";
        str += "Input: ";
        return str;
    }

    public static String welcomeMessage(String name) {
        String message = "Welcome to " + name + " Management System";
        return message;
    }

    public static String noTitleAvailableMessage() {
        String message = "There is no title available at the moment.";
        return message;
    }

    public static String listAvailableBooksMessage() {
        String message = "List All Available Books";
        return message;
    }

    public static String listAvailableMoviesMessage() {
        String message = "List All Available Movies";
        return message;
    }

    public static String invalidInputMessage() {
        String message = "Select a valid option!";
        return message;
    }

    public static String borrowBookMessage() {
        String message = "Enter Movie Title to Borrow: ";
        return message;
    }

    public static String returnBookMessage() {
        String message = "Enter Book Title to Return: ";
        return message;
    }

    public static String borrowMovieMessage() {
        String message = "Enter Movie Title to Borrow: ";
        return message;
    }

    public static String returnMovieMessage() {
        String message = "Enter Movie Title to Return: ";
        return message;
    }

    public static String checkOutBookSuccessfulMessage() {
        String message = "Thank you! Enjoy the book.";
        return message;
    }

    public static String checkOutBookUnsuccessfulMessage() {
        String message = "The book is not available.";
        return message;
    }

    public static String checkOutMovieSuccessfulMessage() {
        String message = "Thank you! Enjoy the movie.";
        return message;
    }

    public static String checkOutMovieUnsuccessfulMessage() {
        String message = "The movie is not available.";
        return message;
    }

    public static String returnBookSuccessfulMessage() {
        String message = "Thank you for returning the book.";
        return message;
    }

    public static String returnBookUnsuccessfulMessage() {
        String message = "That is not a valid book to return.";
        return message;
    }

    public static String returnMovieSuccessfulMessage() {
        String message = "Thank you for returning the movie.";
        return message;
    }

    public static String returnMovieUnsuccessfulMessage() {
        String message = "That is not a valid movie to return.";
        return message;
    }

    public static String enterLoginIdMessage() {
        String message = "Enter Library Number: ";
        return message;
    }

    public static String enterLoginPasswordMessage() {
        String message = "Enter Password: ";
        return message;
    }

    public static String loginSuccessfulAsMessage(String id) {
        String message = "Login Successfully as " + id;
        return message;
    }

    public static String loginUnsuccessfulAsMessage() {
        String message = "Login Failed";
        return message;
    }

    public static String showUsersWithCheckedOutItemsMessage() {
        String message = "List All Users with Checked Out Items";
        return message;
    }

    public static String showUserInformationMessage(User user) {
        String message = "Show User Information\n";
        message += user;
        return message;
    }
}
