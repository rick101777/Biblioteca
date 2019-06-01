package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerificationTest {

    Verification verifier;

    @Before
    public void init(){
        verifier = new Verification();
    }


    @Test
    public void LoginWithIncorrectLibraryNumberTest(){
        User user = verifier.Login("123-1223", "paa");
        assertNull(user);
    }

    @Test
    public void LoginWithCorrectLibraryNumberTest(){
        User user = verifier.Login("111-1111", "tomodachi");
        assertNotNull(user);
    }

    @Test
    public void LoginWithIncorrectPassword(){
        User user = verifier.Login("333-3333", "passwor");
        assertNull(user);
    }


}
