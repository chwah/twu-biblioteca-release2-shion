package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by shion on 15/04/2016.
 */
public class Library {
    private String name;
    private ArrayList<Medium> books;
    private ArrayList<Medium> movies;
    private final int INPUT_TO_QUIT = 9;

    Library(String name) {
        this.name = name;
        books = new ArrayList<Medium>();
        movies = new ArrayList<Medium>();
    }

    public String getName() {
        return name;
    }

    private Medium addMedium(Medium medium, ArrayList<Medium> mediumArrayList) {
        mediumArrayList.add(medium);
        return medium;
    }

    protected Book addBook(Book book) {
        if (book instanceof Book && isValidBook(book)) {
            return (Book) addMedium(book, books);
        }
        return null;
    }

    protected Movie addMovie(Movie movie) {
        if (movie instanceof Movie && isValidMovie(movie)) {
            return (Movie) addMedium(movie, movies);
        }
        return null;
    }

    protected ArrayList<Medium> getBooks() {
        return books;
    }

    protected ArrayList<Medium> getMovies() {
        return movies;
    }

    private Medium getMediumInList(String title, ArrayList<Medium> mediumArrayList) {
        for (Medium medium : mediumArrayList) {
            if (medium.getTitle().equalsIgnoreCase(title)) return medium;
        }
        return null;
    }

    protected Book getBookWithTitle(String bookTitle) {
        return (Book) getMediumInList(bookTitle, books);
    }

    protected Movie getMovieWithTitle(String movieTitle) {
        return (Movie) getMediumInList(movieTitle, movies);
    }

    private void listMediumTitles(ArrayList<Medium> mediumArrayList) {
        int counter = 0;

        for (Medium medium : mediumArrayList) {
            if (medium.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + medium.getTitle());
            }
        }

        if (counter == 0) System.out.println("There is no title available at the moment.");

        System.out.println();
    }

    protected void listBooks() {
        System.out.println("List All Available Books");
        listMediumTitles(books);
    }

    protected void listMovies() {
        System.out.println("List All Available Movies");
        listMediumTitles(movies);
    }

    private void listMediumWithDetails(ArrayList<Medium> mediumArrayList) {
        int counter = 0;

        for (Medium medium : mediumArrayList) {
            if (medium.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + medium.toString());
            }
        }

        if (counter == 0) System.out.println("There is no title available at the moment.");

        System.out.println();
    }

    protected void listBooksWithDetails() {
        System.out.println("List All Available Books with Details");
        listMediumWithDetails(books);
    }

    protected void listMoviesWithDetails() {
        System.out.println("List All Available Movies with Details");
        listMediumWithDetails(movies);
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
                    listBooksWithDetails();
                    break;
                case 3:
                    listMoviesWithDetails();
                    break;
                case 4:
                    showCheckOutBookMenu();;
                    break;
                case 5:
                    showCheckOutMovieMenu();;
                    break;
                case 6:
                    showReturnBookMenu();
                    break;
                case 7:
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
        str += "2. List Books with Details\n";
        str += "3. List Movies\n";
        str += "4. Checkout Book\n";
        str += "5. Checkout Movie\n";
        str += "6. Return Book\n";
        str += "7. Return Movie\n";
        str += "8. Quit\n\n";
        str += "Input: ";
        System.out.print(str);
    }

    private void showInvalidInput() {
        System.out.println("Select a valid option!\n");
    }

    private void showCheckOutBookMenu() {
        System.out.print("Enter Book Title to Borrow: ");
        String bookTitle = InputProcessor.getUserInputAsString();
        checkOutBookWithTitle(bookTitle);
        System.out.println();
    }

    private void showReturnBookMenu() {
        System.out.print("Enter Book Title to Return: ");
        String bookTitle = InputProcessor.getUserInputAsString();
        returnBookWithTitle(bookTitle);
        System.out.println();
    }

    private void showCheckOutMovieMenu() {
        System.out.print("Enter Movie Title to Borrow: ");
        String movieTitle = InputProcessor.getUserInputAsString();
        checkOutMovieWithTitle(movieTitle);
        System.out.println();
    }

    private void showReturnMovieMenu() {
        System.out.print("Enter Movie Title to Return: ");
        String movieTitle = InputProcessor.getUserInputAsString();
        returnMovieWithTitle(movieTitle);
        System.out.println();
    }

    private Medium checkOutMedium(Medium medium) {
        if (medium != null && medium.isAvailable()) {
            medium.setCheckedOut(true);
            return medium;
        }
        return null;
    }

    protected Book checkOutBookWithTitle(String bookTitle) {
        Book book = getBookWithTitle(bookTitle);
        book = (Book) checkOutMedium(book);

        if (book != null) {
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("The book is not available.");
        }

        return book;
    }

    protected Movie checkOutMovieWithTitle(String movieTitle) {
        Movie movie = getMovieWithTitle(movieTitle);
        movie = (Movie) checkOutMedium(movie);

        if (movie != null) {
            System.out.println("Thank you! Enjoy the movie.");
        } else {
            System.out.println("The movie is not available.");
        }

        return movie;
    }

    private Medium returnMedium(Medium medium) {
        if (medium != null && !medium.isAvailable()) {
            medium.setCheckedOut(false);
            return medium;
        }
        return null;
    }

    protected Book returnBookWithTitle(String bookTitle) {
        Book book = getBookWithTitle(bookTitle);
        book = (Book) returnMedium(book);

        if (book != null) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }

        return book;
    }

    protected Movie returnMovieWithTitle(String movieTitle) {
        Movie movie = getMovieWithTitle(movieTitle);
        movie = (Movie) returnMedium(movie);

        if (movie != null) {
            System.out.println("Thank you for returning the movie.");
        } else {
            System.out.println("That is not a valid movie to return.");
        }

        return movie;
    }

}
