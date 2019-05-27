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
    public void CheckoutTestSuccess(){
        library.Checkout("Le Petit Prince");
        assertTrue(!library.toString().contains("Le Petit Prince"));
    }

    @Test
    public void CheckoutTestSuccess1(){
        library.Checkout("Harry Potter and the Philosopher's Stone");
        assertTrue(!library.toString().contains("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void CheckoutTestSuccess2(){
        library.Checkout("The Hobbit");
        assertTrue(!library.toString().contains("The Hobbit"));
    }

    @Test
    public void CheckoutTestSuccess3(){
        library.Checkout("The Lion, the Witch and the Wardrobe");
        assertTrue(!library.toString().contains("The Lion, the Witch and the Wardrobe"));
    }

    @Test
    public void ReturnTestSuccess1(){
        library.Checkout("Le Petit Prince");
        library.Return("Le Petit Prince");
        assertTrue(library.toString().contains("Le Petit Prince"));
    }


    @Test
    public void BookSearchTestFailure(){
        Book book = library.BookSearch("Le Peee");
        assertNull(book);
    }

}
