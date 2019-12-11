package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Library implements Cloneable {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return books.equals(library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    protected Library clone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library shallowCopy() {
        Library copy = null;
        try {
            copy = clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

    public Library deepCopy() {
        Library libraryCopy = shallowCopy();
        Set<Book> booksCopy = new HashSet<>();
        
        books.forEach(book -> booksCopy.add(new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate())));
        libraryCopy.books = booksCopy;
        
        return libraryCopy;
    }
}
