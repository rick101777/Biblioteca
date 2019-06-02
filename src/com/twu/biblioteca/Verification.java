package com.twu.biblioteca;

import java.util.HashMap;

public class Verification {

    private HashMap<String, String> libraryCredentials; // Unique library number | Unique Password
    private HashMap<String, User> users; // Unique: library number | User object

    public Verification(){
        libraryCredentials = new HashMap<>();

        libraryCredentials.put("333-3333", "password");
        libraryCredentials.put("444-4444", "life");
        libraryCredentials.put("111-1111", "tomodachi");

        users = new HashMap<>();

        users.put("333-3333", new User("John", "j.Howard@gmail.com", "223-111-3333"));
        users.put("444-4444", new User("Tom", "t.Fredrick@yahoo.com", "555-231-0421"));
        users.put("111-1111", new User("Jerry", "j.Jackson@aol.com", "012-932-1231"));
    }

    private boolean Verify(String libraryNumber, String password){
        String value = libraryCredentials.get(libraryNumber);
        if (value != null && value.equals(password)){
            return true;
        }
        return false;
    }

    public User Login(String libraryNumber, String password){
        if (Verify(libraryNumber, password)){
            User user = users.get(libraryNumber);
            System.out.println("Welcome to Biblioteca, " + user.getName());
            return user;
        }
        System.out.println("Incorrect library number, or password");
        return null;
    }

}
