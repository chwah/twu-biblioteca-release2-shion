package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library biblioteca = new Library("Bangalore Public Library");
        populateLibrary(biblioteca);
        biblioteca.runLibrary();
    }

    private static void populateLibrary(Library library) {
        int totalUniqueMedium = 3;
        for (int i = 1 ; i <= totalUniqueMedium ; i++) {
            Book book = new Book("Book Title " + i, "Author " + i, 2000 + i);
            Movie movie = new Movie("Movie Title " + i, "Director " + i, 2000 + i, i-1);
            library.addBook(book);
            library.addMovie(movie);
        }
    }
}
