package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by shion on 15/04/2016.
 */
public class Library {
    private String name;
    private ArrayList<Medium> books;
    private ArrayList<Medium> movies;
    private ArrayList<User> users;
    private User currentUser;
    private final int INPUT_TO_QUIT = 0;

    Library(String name) {
        this.name = name;
        books = new ArrayList<Medium>();
        movies = new ArrayList<Medium>();
        users = new ArrayList<User>();
        currentUser = null;
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

    protected User addUser(User user) {
        if (user instanceof User) {
            getUsers().add(user);
            return user;
        }
        return null;
    }

    protected ArrayList<Medium> getBooks() {
        return books;
    }

    protected ArrayList<Medium> getMovies() {
        return movies;
    }

    private ArrayList<User> getUsers() {
        return users;
    }

    protected Book getBookWithTitle(String bookTitle) {
        return (Book) getMediumInList(bookTitle, books);
    }

    protected Movie getMovieWithTitle(String movieTitle) {
        return (Movie) getMediumInList(movieTitle, movies);
    }

    private Medium getMediumInList(String title, ArrayList<Medium> mediumArrayList) {
        for (Medium medium : mediumArrayList) {
            if (medium.getTitle().equalsIgnoreCase(title)) return medium;
        }
        return null;
    }

    protected void listBooks() {
        System.out.println(LibraryUI.listAvailableBooksMessage());
        listMediumTitles(books);
    }

    protected void listMovies() {
        System.out.println(LibraryUI.listAvailableMoviesMessage());
        listMediumTitles(movies);
    }

    private void listMediumTitles(ArrayList<Medium> mediumArrayList) {
        int counter = 0;

        for (Medium medium : mediumArrayList) {
            if (medium.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + medium.getTitle());
            }
        }

        if (counter == 0) System.out.println(LibraryUI.noTitleAvailableMessage());

        System.out.println();
    }

    protected void listBooksWithDetails() {
        System.out.println(LibraryUI.listAvailableBooksMessage());
        listMediumWithDetails(books);
    }

    protected void listMoviesWithDetails() {
        System.out.println(LibraryUI.listAvailableBooksMessage());
        listMediumWithDetails(movies);
    }

    private void listMediumWithDetails(ArrayList<Medium> mediumArrayList) {
        int counter = 0;

        for (Medium medium : mediumArrayList) {
            if (medium.isAvailable()) {
                counter++;
                System.out.println(counter + ". " + medium.toString());
            }
        }

        if (counter == 0) System.out.println(LibraryUI.noTitleAvailableMessage());

        System.out.println();
    }

    protected boolean isValidBook(Book book) {
        return book.isValidBook();
    }

    protected boolean isValidMovie(Movie movie) {
        return movie.isValidMovie();
    }

    protected void runLibrary() {
        System.out.println(LibraryUI.welcomeMessage(getName()));

        runLoginMenu();
    }

    private void runLoginMenu() {
        String inputId = "";
        String inputPassword = "";

        while (currentUser == null) {
            System.out.print(LibraryUI.enterLoginIdMessage());
            inputId = InputProcessor.getUserInputAsString();

            System.out.print(LibraryUI.enterLoginPasswordMessage());
            inputPassword = InputProcessor.getUserInputAsString();

            login(inputId, inputPassword);

            if (currentUser != null) {
                System.out.println(LibraryUI.loginSuccessfulAsMessage(currentUser.getId()) + "\n");
                System.out.println(LibraryUI.loginUnsuccessfulAsMessage() + "\n");
                runMainMenu();
            } else {
                System.out.println(LibraryUI.loginUnsuccessfulAsMessage() + "\n");
            }
        }
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
                case 8:
                    showUserSpecificMenu();
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
        if (currentUser instanceof Librarian) {
            System.out.print(LibraryUI.mainMenuLibrarian());
        } else {
            System.out.print(LibraryUI.mainMenuCustomer());
        }
    }

    private void showInvalidInput() {
        System.out.println(LibraryUI.invalidInputMessage());
        System.out.println();
    }

    private void showCheckOutBookMenu() {
        System.out.print(LibraryUI.borrowBookMessage());
        String bookTitle = InputProcessor.getUserInputAsString();
        checkOutBookWithTitle(bookTitle);
        System.out.println();
    }

    private void showReturnBookMenu() {
        System.out.print(LibraryUI.returnBookMessage());
        String bookTitle = InputProcessor.getUserInputAsString();
        returnBookWithTitle(bookTitle);
        System.out.println();
    }

    private void showCheckOutMovieMenu() {
        System.out.print(LibraryUI.borrowMovieMessage());
        String movieTitle = InputProcessor.getUserInputAsString();
        checkOutMovieWithTitle(movieTitle);
        System.out.println();
    }

    private void showReturnMovieMenu() {
        System.out.print(LibraryUI.returnMovieMessage());
        String movieTitle = InputProcessor.getUserInputAsString();
        returnMovieWithTitle(movieTitle);
        System.out.println();
    }

    private void showUserSpecificMenu() {
        if (currentUser instanceof Librarian) {
            showUsersWithCheckedOutItems();
        } else {
            showUserInformation();
        }
    }

    protected Book checkOutBookWithTitle(String bookTitle) {
        Book book = getBookWithTitle(bookTitle);
        book = (Book) checkOutMedium(book);

        if (book != null) {
            System.out.println(LibraryUI.checkOutBookSuccessfulMessage());
        } else {
            System.out.println(LibraryUI.checkOutBookUnsuccessfulMessage());
        }

        return book;
    }

    protected Movie checkOutMovieWithTitle(String movieTitle) {
        Movie movie = getMovieWithTitle(movieTitle);
        movie = (Movie) checkOutMedium(movie);

        if (movie != null) {
            System.out.println(LibraryUI.checkOutMovieSuccessfulMessage());
        } else {
            System.out.println(LibraryUI.checkOutMovieUnsuccessfulMessage());
        }

        return movie;
    }

    private Medium checkOutMedium(Medium medium) {
        if (medium != null && medium.isAvailable()) {
            medium.setCheckedOut(true);
            currentUser.addCheckedOutItems(medium);
            return medium;
        }
        return null;
    }

    protected Book returnBookWithTitle(String bookTitle) {
        Book book = getBookWithTitle(bookTitle);
        book = (Book) returnMedium(book);

        if (book != null) {
            System.out.println(LibraryUI.returnBookSuccessfulMessage());
        } else {
            System.out.println(LibraryUI.returnBookUnsuccessfulMessage());
        }

        return book;
    }

    protected Movie returnMovieWithTitle(String movieTitle) {
        Movie movie = getMovieWithTitle(movieTitle);
        movie = (Movie) returnMedium(movie);

        if (movie != null) {
            System.out.println(LibraryUI.returnMovieSuccessfulMessage());
        } else {
            System.out.println(LibraryUI.returnMovieUnsuccessfulMessage());
        }

        return movie;
    }

    private Medium returnMedium(Medium medium) {
        if (medium != null && !medium.isAvailable() && currentUser.hasCheckedOutItem(medium)) {
            medium.setCheckedOut(false);
            currentUser.removeCheckedOutItems(medium);
            return medium;
        }
        return null;
    }

    private void showUsersWithCheckedOutItems() {
        System.out.println(LibraryUI.showUsersWithCheckedOutItemsMessage());
        for (User user : getUsers()) {
            if (user.getCheckedOutItems().size() > 0) {
                System.out.println(user.getId());

                for (Medium medium : user.getCheckedOutItems()) {
                    System.out.println(medium);
                }

                System.out.println();
            }
        }
    }

    private void showUserInformation() {
        System.out.println(LibraryUI.showUserInformationMessage(currentUser));
        System.out.println();
    }

    protected User login(String id, String password) {
        for (User user : getUsers()) {
            if (credentialsIsValid(user, id, password)) {
                currentUser = user;
                return currentUser;
            }
        }
        return null;
    }

    private boolean credentialsIsValid(User user, String id, String password) {
        if (user.getId().equals(id) && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
