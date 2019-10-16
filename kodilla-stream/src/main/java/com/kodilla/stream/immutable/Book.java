package com.kodilla.stream.immutable;

public final class Book {
    //immutable class - instance variables are declared final - after creation of instance they cannot be changed
    
    private final String title;
    private final String author;
    private final int yearOfPublication;

    public Book(final String title, final String author,
                final int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
