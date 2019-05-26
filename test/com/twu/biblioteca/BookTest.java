package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BookTest {

    Book book;

    @Before
    public void initialize(){
        book = new Book("Harry Potter", "J.K. Rowling", 2013);
    }

    @Test
    public void initTest(){
        assertNotNull(book);
    }

    @Test
    public void CheckOutSuccessTest(){
        boolean checkOutStatus = book.Checkout();
        assertTrue(checkOutStatus);
    }

    @Test
    public void CheckOutFalureTest(){
        book.Checkout();
        boolean checkOutStatus = book.Checkout();
        assertFalse(checkOutStatus);
    }

    @Test
    public void ReturnSuccessTest(){
        book.Checkout();
        boolean returnStatus = book.Return();
        assertTrue(returnStatus);
    }

    @Test
    public void ReturnFailureTest(){
        book.Checkout();
        book.Return();
        boolean returnStatus = book.Return();
        assertFalse(returnStatus);
    }

}