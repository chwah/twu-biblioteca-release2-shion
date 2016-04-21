package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by shion on 15/04/2016.
 */
public class Library {
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private final int INPUT_TO_QUIT = 9;

    Library(String name) {
        this.name = name;
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
    }

    public String getName() {
        return name;
    }

    protected Medium add(Medium medium) {
        if (medium instanceof Book && isValidBook((Book) medium)) {
            books.add((Book) medium);
            return (Book) medium;
        } else if (medium instanceof Movie && isValidMovie((Movie) medium)) {
            movies.add((Movie) medium);
            return (Movie) medium;
        }
        return null;
    }

    protected ArrayList<Book> getBooks() {
        return books;
    }

    protected ArrayList<Movie> getMovies() {
        return movies;
    }

    protected Book getBookWithTitle(String bookTitle) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(bookTitle)) return b;
        }
        return null;
    }

    protected Movie getMovieWithTitle(String movieTitle) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(movieTitle)) return m;
        }
        return null;
    }

    protected void listBooks() {
        System.out.println("List All Books");

        int counter = 0;
        for (Book b : books) {
            if (b.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + b.getTitle());
            }
        }

        if (counter == 0) System.out.println("There is no book available at the moment.");

        System.out.println();
    }

    protected void listMovies() {
        System.out.println("List All Movies");

        int counter = 0;
        for (Movie m : movies) {
            if (m.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + m.getTitle());
            }
        }

        if (counter == 0) System.out.println("There is no movie available at the moment.");

        System.out.println();
    }

    protected void listBooksWithDetails() {
        System.out.println("List All Books with Details");

        int counter = 0;
        for (Book b : books) {
            if (b.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + b.toString());
            }
        }

        if (counter == 0) System.out.println("There is no book available at the moment.");

        System.out.println();
    }

    protected void listMoviesWithDetails() {
        System.out.println("List All Movies with Details");

        int counter = 0;
        for (Movie m : movies) {
            if (m.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + m.toString());
            }
        }

        if (counter == 0) System.out.println("There is no movie available at the moment.");

        System.out.println();
    }

    protected boolean isValidBook(Book book) {
        return book.isValidBook();
    }

    protected boolean isValidMovie(Movie movie) {
        return movie.isValidMovie();
    }

    protected void runLibrary() {
        System.out.println("Welcome to " + name + " Management System");
        runMainMenu();
    }

    private void runMainMenu() {
        int input = -1;
        while (input != INPUT_TO_QUIT) {
            showMenu();
            input = InputProcessor.getUserInputAsInteger();

            switch (input) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    listMovies();
                    break;
                case 3:
                    listBooksWithDetails();
                    break;
                case 4:
                    listMoviesWithDetails();
                    break;
                case 5:
                    showCheckOutBookMenu();;
                    break;
                case 6:
                    showCheckOutMovieMenu();;
                    break;
                case 7:
                    showReturnBookMenu();
                    break;
                case 8:
                    showReturnMovieMenu();
                    break;
                case INPUT_TO_QUIT:
                    break;
                default:
                    showInvalidInput();
                    break;
            }
        }
    }

    private void showMenu() {
        String str = "";
        str += "1. List Books\n";
        str += "2. List Movies\n";
        str += "3. List Books with Details\n";
        str += "4. List Movies with Details\n";
        str += "5. Checkout Book\n";
        str += "6. Checkout Movie\n";
        str += "7. Return Book\n";
        str += "8. Return Movie\n";
        str += "9. Quit\n\n";
        str += "Input: ";
        System.out.print(str);
    }

    private void showInvalidInput() {
        System.out.println("Select a valid option!\n");
    }

    private void showCheckOutBookMenu() {
        System.out.print("Enter Title to Borrow: ");
        String bookTitle = InputProcessor.getUserInputAsString();
        checkOutBookWithTitle(bookTitle);
        System.out.println();
    }

    private void showReturnBookMenu() {
        System.out.print("Enter Title to Return: ");
        String bookTitle = InputProcessor.getUserInputAsString();
        returnBookWithTitle(bookTitle);
        System.out.println();
    }

    private void showCheckOutMovieMenu() {
        System.out.print("Enter Title to Borrow: ");
        String movieTitle = InputProcessor.getUserInputAsString();
        checkOutMovieWithTitle(movieTitle);
        System.out.println();
    }

    private void showReturnMovieMenu() {
        System.out.print("Enter Title to Return: ");
        String movieTitle = InputProcessor.getUserInputAsString();
        returnMovieWithTitle(movieTitle);
        System.out.println();
    }

    protected boolean checkOutBookWithTitle(String bookTitle) {
        Book book = getBookWithTitle(bookTitle);

        if (book != null && book.isAvailable()) {
            System.out.println("Thank you! Enjoy the book.");
            book.setCheckedOut(true);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    protected boolean returnBookWithTitle(String bookTitle) {
        Book book = getBookWithTitle(bookTitle);

        if (book != null && !book.isAvailable()) {
            System.out.println("Thank you for returning the book.");
            book.setCheckedOut(false);
            return true;
        } else {
            System.out.println("That is not a valid book to return.");
            return false;
        }
    }

    protected boolean checkOutMovieWithTitle(String movieTitle) {
        Movie movie = getMovieWithTitle(movieTitle);

        if (movie != null && movie.isAvailable()) {
            System.out.println("Thank you! Enjoy the movie.");
            movie.setCheckedOut(true);
            return true;
        } else {
            System.out.println("The movie is not available.");
            return false;
        }
    }

    protected boolean returnMovieWithTitle(String movieTitle) {
        Movie movie = getMovieWithTitle(movieTitle);

        if (movie != null && !movie.isAvailable()) {
            System.out.println("Thank you for returning the movie.");
            movie.setCheckedOut(false);
            return true;
        } else {
            System.out.println("That is not a valid movie to return.");
            return false;
        }
    }

}
