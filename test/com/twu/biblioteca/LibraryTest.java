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
        library.add(book1);
        library.add(book2);

        ArrayList<Book> books = library.getBooks();

        assertTrue(books.size() == 2);
        assertTrue(books.contains(book1) == true);
        assertTrue(books.contains(book2) == true);
    }

    @Test
    public void canAddBook() {
        Library library = new Library("Test Library");
        Book book = new Book("Available Title", "Test Author", 2016);

        assertTrue(library.add(book) != null);
    }

    @Test
    public void cannotAddBook() {
        Library library = new Library("Test Library");
        Book book1 = new Book("", "Test Author", 2016);
        Book book2 = new Book("Test Title", "", 2016);
        Book book3 = new Book("Test Title", "Test Author", 0);

        assertTrue(library.add(book1) == null);
        assertTrue(library.add(book2) == null);
        assertTrue(library.add(book3) == null);
    }

    @Test
    public void successfullyCheckOutBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Available Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.add(book);

        assertTrue(library.checkOutBookWithTitle("Available Title") == true);
        assertTrue(book.isAvailable() == false);
    }

    @Test
    public void unsuccessfullyCheckOutBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Unavailable Title", "Test Author", 2016);
        book.setCheckedOut(true);
        library.add(book);

        assertTrue(library.checkOutBookWithTitle("Unavailable Title") == false);
        assertTrue(library.checkOutBookWithTitle("Non-existent Title") == false);
        assertTrue(book.isAvailable() == false);
    }

    @Test
    public void successfullyReturnBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Unavailable Title", "Test Author", 2016);
        book.setCheckedOut(true);
        library.add(book);

        assertTrue(library.returnBookWithTitle("Unavailable Title") == true);
        assertTrue(book.isAvailable() == true);
    }

    @Test
    public void unsuccessfullyReturnBook() {
        Library library = new Library("Test Library");

        Book book = new Book("Available Title", "Test Author", 2016);
        book.setCheckedOut(false);
        library.add(book);

        assertTrue(library.returnBookWithTitle("Available Title") == false);
        assertTrue(library.returnBookWithTitle("Non-existent Title") == false);
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
        library.add(movie1);
        library.add(movie2);

        ArrayList<Movie> movies = library.getMovies();

        assertTrue(movies.size() == 2);
        assertTrue(movies.contains(movie1) == true);
        assertTrue(movies.contains(movie2) == true);
    }

    @Test
    public void canAddMovie() {
        Library library = new Library("Test Library");
        Movie movie = new Movie("Test Title", "Test Director", 2016, 10);

        assertTrue(library.add(movie) != null);
    }

    @Test
    public void cannotAddMovie() {
        Library library = new Library("Test Library");
        Movie movie1 = new Movie("", "Test Director", 2016, 10);
        Movie movie2 = new Movie("Test Title", "", 2016, 10);
        Movie movie3 = new Movie("Test Title", "Test Director", 0, 10);
        Movie movie4 = new Movie("Test Title", "Test Director", 2016, 100);

        assertTrue(library.add(movie1) == null);
        assertTrue(library.add(movie2) == null);
        assertTrue(library.add(movie3) == null);
        assertTrue(library.add(movie4) == null);
    }

    @Test
    public void successfullyCheckOutMovie() {
        Library library = new Library("Test Library");

        Movie movie = new Movie("Available Title", "Test Director", 2016, 10);
        movie.setCheckedOut(false);
        library.add(movie);

        assertTrue(library.checkOutMovieWithTitle("Available Title") == true);
        assertTrue(movie.isAvailable() == false);
    }

    @Test
    public void unsuccessfullyCheckOutMovie() {
        Library library = new Library("Test Library");

        Movie movie = new Movie("Available Title", "Test Director", 2016, 10);
        movie.setCheckedOut(true);
        library.add(movie);

        assertTrue(library.checkOutMovieWithTitle("Unavailable Title") == false);
        assertTrue(library.checkOutMovieWithTitle("Non-existent Title") == false);
        assertTrue(movie.isAvailable() == false);
    }

    @Test
    public void successfullyReturnMovie() {
        Library library = new Library("Test Library");

        Movie movie = new Movie("Unavailable Title", "Test Director", 2016, 10);
        movie.setCheckedOut(true);
        library.add(movie);

        assertTrue(library.returnMovieWithTitle("Unavailable Title") == true);
        assertTrue(movie.isAvailable() == true);
    }

    @Test
    public void unsuccessfullyReturnMovie() {
        Library library = new Library("Test Library");

        Movie movie = new Movie("Available Title", "Test Director", 2016, 10);
        movie.setCheckedOut(false);
        library.add(movie);

        assertTrue(library.returnMovieWithTitle("Available Title") == false);
        assertTrue(library.returnMovieWithTitle("Non-existent Title") == false);
    }
}