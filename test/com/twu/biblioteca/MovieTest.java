package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    Movie movie;

    @Before
    public void init(){
        movie = new Movie("The Godfather", 1972, "Francis Ford Coppola", 9.2);
    }

    @Test
    public void CheckoutTest(){
        assertTrue(movie.Checkout());
    }

    @Test
    public void ReturnTest(){
        movie.Checkout();
        assertTrue(movie.Return());
    }

    @Test
    public void CheckoutStatusUpdateTest(){
        movie.Checkout();
        assertTrue(movie.isCheckedout());
    }

    @Test
    public void NotCheckoutStatus(){
        assertFalse(movie.isCheckedout());
    }

    @Test
    public void ReturnedStatusUpdateTest(){
        movie.Checkout();
        movie.Return();
        assertFalse(movie.isCheckedout());
    }


}
