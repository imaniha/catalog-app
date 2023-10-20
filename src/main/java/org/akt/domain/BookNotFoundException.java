package org.akt.domain;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("the book with ISBN " + isbn + " was not found.");
    }
}
