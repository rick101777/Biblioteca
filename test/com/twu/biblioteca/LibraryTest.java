package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;

    @Before
    public void init(){
        library = new Library();
        library.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 1943));
        library.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        library.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));
    }

    @Test
    public void BookSearchTestSuccess(){
        Book book = library.BookSearch("Le Petit Prince");
        assertNotNull(book);
    }

    @Test
    public void BookSearchTestSuccess1(){
        Book book = library.BookSearch("Harry Potter and the Philosopher's Stone");
        assertNotNull(book);
    }

    @Test
    public void BookSearchTestSuccess2(){
        Book book = library.BookSearch("The Hobbit");
        assertNotNull(book);
    }

    @Test
    public void BookSearchTestSuccess3(){
        Book book = library.BookSearch("The Lion, the Witch and the Wardrobe");
        assertNotNull(book);
    }

    @Test
    public void BookSearchTestFailure(){
        Book book = library.BookSearch("Le Peee");
        assertNull(book);
    }

}
