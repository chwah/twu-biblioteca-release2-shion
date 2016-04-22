package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by shion on 15/04/2016.
 */
public class LibraryTest {
    @Test
    public void libraryIsValid() {
        Library library = new Library("Test Library");

        assertTrue(library.getName() == "Test Library");
        assertTrue(library.getBooks().isEmpty() == true);
        assertTrue(library.getMovies().isEmpty() == true);
    }

    @Test
    public void bookIsValid() {
        Library library = new Library("Test Library");
        Book book = new Book("Test Title", "Test Author", 2016);

        assertTrue(library.isValidBook(book) == true);
    }

    @Test
    public void bookIsNotValid() {
        Library library = new Library("Test Library");
        Book book1 = new Book("", "Test Author", 2016);
        Book book2 = new Book("Test Title", "", 2016);
        Book book3 = new Book("Test Title", "Test Author", 0);

        assertTrue(library.isValidBook(book1) == false);
        assertTrue(library.isValidBook(book2) == false);
        assertTrue(library.isValidBook(book3) == false);
    }

    @Test
    public void getListOfBooks() {
        Library library = new Library("Test Library");
        Book book1 = new Book("Test Title 1", "Test Author 1", 2016);
        Book book2 = new Book("Test Title 2", "Test Author 2", 2015);
        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Medium> books = library.getBooks();

        assertTrue(books.size() == 2);
        assertTrue(books.contains(book1) == true);
        assertTrue(books.contains(book2) == true);
    }

    @Test
    public void canAddBook() {
        Library library = new Library("Test Library");
        Book book = new Book("Available Title", "Test Author", 2016);

        assertTrue(library.addBook(book) == book);
    }

    @Test
    public void cannotAddBook() {
        Library library = new Library("Test Library");
        Book book1 = new Book("", "Test Author", 2016);
        Book book2 = new Book("Test Title", "", 2016);
        Book book3 = new Book("Test Title", "Test Author", 0);

        assertTrue(library.addBook(book1) == null);
        assertTrue(library.addBook(book2) == null);
        assertTrue(library.addBook(book3) == null);
    }

    @Test
    public void successfullyCheckOutBook() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Book book = new Book("Available Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        assertTrue(book.isAvailable() == true);
        assertTrue(customer.hasCheckedOutItem(book) == false);
        assertTrue(library.checkOutBookWithTitle("Available Title") == book);
        assertTrue(book.isAvailable() == false);
        assertTrue(customer.hasCheckedOutItem(book) == true);
    }

    @Test
    public void unsuccessfullyCheckOutBook() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Book book = new Book("Unavailable Title", "Test Author", 2016);
        book.setCheckedOut(true);
        library.addBook(book);

        assertTrue(book.isAvailable() == false);
        assertTrue(customer.hasCheckedOutItem(book) == false);
        assertTrue(library.checkOutBookWithTitle("Unavailable Title") == null);
        assertTrue(library.checkOutBookWithTitle("Non-existent Title") == null);
        assertTrue(book.isAvailable() == false);
        assertTrue(customer.hasCheckedOutItem(book) == false);
    }

    @Test
    public void successfullyReturnBook() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Book book = new Book("Unavailable Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        library.checkOutBookWithTitle("Unavailable Title");

        assertTrue(book.isAvailable() == false);
        assertTrue(customer.hasCheckedOutItem(book) == true);
        assertTrue(library.returnBookWithTitle("Unavailable Title") == book);
        assertTrue(book.isAvailable() == true);
        assertTrue(customer.hasCheckedOutItem(book) == false);
    }

    @Test
    public void unsuccessfullyReturnBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Available Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        assertTrue(book.isAvailable() == true);
        assertTrue(library.returnBookWithTitle("Available Title") == null);
        assertTrue(library.returnBookWithTitle("Non-existent Title") == null);
        assertTrue(book.isAvailable() == true);
    }

    @Test
    public void movieIsValid() {
        Library library = new Library("Test Library");
        Movie movie = new Movie("Test Title", "Test Director", 2016, 10);

        assertTrue(library.isValidMovie(movie) == true);
    }

    @Test
    public void movieIsNotValid() {
        Library library = new Library("Test Library");
        Movie movie1 = new Movie("", "Test Director", 2016, 10);
        Movie movie2 = new Movie("Test Title", "", 2016, 10);
        Movie movie3 = new Movie("Test Title", "Test Director", 0, 10);
        Movie movie4 = new Movie("Test Title", "Test Director", 2016, 100);

        assertTrue(library.isValidMovie(movie1) == false);
        assertTrue(library.isValidMovie(movie2) == false);
        assertTrue(library.isValidMovie(movie3) == false);
        assertTrue(library.isValidMovie(movie4) == false);
    }

    @Test
    public void getListOfMovies() {
        Library library = new Library("Test Library");
        Movie movie1 = new Movie("Test Title 1", "Test Director", 2016, 10);
        Movie movie2 = new Movie("Test Title 1", "Test Director", 2015, 9);
        library.addMovie(movie1);
        library.addMovie(movie2);

        ArrayList<Medium> movies = library.getMovies();

        assertTrue(movies.size() == 2);
        assertTrue(movies.contains(movie1) == true);
        assertTrue(movies.contains(movie2) == true);
    }

    @Test
    public void canAddMovie() {
        Library library = new Library("Test Library");
        Movie movie = new Movie("Test Title", "Test Director", 2016, 10);

        assertTrue(library.addMovie(movie) == movie);
    }

    @Test
    public void cannotAddMovie() {
        Library library = new Library("Test Library");
        Movie movie1 = new Movie("", "Test Director", 2016, 10);
        Movie movie2 = new Movie("Test Title", "", 2016, 10);
        Movie movie3 = new Movie("Test Title", "Test Director", 0, 10);
        Movie movie4 = new Movie("Test Title", "Test Director", 2016, 100);

        assertTrue(library.addMovie(movie1) == null);
        assertTrue(library.addMovie(movie2) == null);
        assertTrue(library.addMovie(movie3) == null);
        assertTrue(library.addMovie(movie4) == null);
    }

    @Test
    public void successfullyCheckOutMovie() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Movie movie = new Movie("Available Title", "Test Director", 2016, 10);
        movie.setCheckedOut(false);
        library.addMovie(movie);

        assertTrue(movie.isAvailable() == true);
        assertTrue(customer.hasCheckedOutItem(movie) == false);
        assertTrue(library.checkOutMovieWithTitle("Available Title") == movie);
        assertTrue(movie.isAvailable() == false);
        assertTrue(customer.hasCheckedOutItem(movie) == true);
    }

    @Test
    public void unsuccessfullyCheckOutMovie() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Movie movie = new Movie("Available Title", "Test Director", 2016, 10);
        movie.setCheckedOut(true);
        library.addMovie(movie);

        assertTrue(movie.isAvailable() == false);
        assertTrue(library.checkOutMovieWithTitle("Unavailable Title") == null);
        assertTrue(library.checkOutMovieWithTitle("Non-existent Title") == null);
        assertTrue(movie.isAvailable() == false);
    }

    @Test
    public void successfullyReturnMovie() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Movie movie = new Movie("Unavailable Title", "Test Director", 2016, 10);
        movie.setCheckedOut(false);
        library.addMovie(movie);

        library.checkOutMovieWithTitle("Unavailable Title");

        assertTrue(movie.isAvailable() == false);
        assertTrue(customer.hasCheckedOutItem(movie) == true);
        assertTrue(library.returnMovieWithTitle("Unavailable Title") == movie);
        assertTrue(movie.isAvailable() == true);
        assertTrue(customer.hasCheckedOutItem(movie) == false);
    }

    @Test
    public void unsuccessfullyReturnMovie() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Movie movie = new Movie("Available Title", "Test Director", 2016, 10);
        movie.setCheckedOut(true);
        library.addMovie(movie);

        assertTrue(movie.isAvailable() == false);
        assertTrue(library.returnMovieWithTitle("Available Title") == null);
        assertTrue(library.returnMovieWithTitle("Non-existent Title") == null);
        assertTrue(movie.isAvailable() == false);
    }

    @Test
    public void loginSuccessful() {
        Library library = new Library("Test Library");

        Librarian librarian = new Librarian("000-0001", "password");
        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(librarian);
        library.addUser(customer);

        assertTrue(library.login("000-0001", "password") == librarian);
        assertTrue(library.login("111-0001", "password") == customer);
    }

    @Test
    public void loginUnsuccessful() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);

        assertTrue(library.login("111-9999", "password") == null);
        assertTrue(library.login("000-0001", "wrongpassword") == null);
    }

    @Test
    public void getUserCheckedOutItems() {
        Library library = new Library("Test Library");

        Customer customer = new Customer("111-0001", "password", "Name", "name@email.com", "12345678");
        library.addUser(customer);
        library.login("111-0001", "password");

        Book book = new Book("Available Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.addBook(book);

        Movie movie = new Movie("Available Title", "Test Director", 2016, 10);
        movie.setCheckedOut(false);
        library.addMovie(movie);

        library.checkOutBookWithTitle("Available Title");
        library.checkOutMovieWithTitle("Available Title");

        assertTrue(customer.getCheckedOutItems().size() == 2);
        assertTrue(customer.getCheckedOutItems().contains(book) == true);
        assertTrue(customer.getCheckedOutItems().contains(movie) == true);
    }
}