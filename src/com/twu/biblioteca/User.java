package com.twu.biblioteca;



public class User {

    private String name;
    private String email;
    private int phoneNumber;
    private boolean isLoggedIn;

    public User(String name, String email, int phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isLoggedIn = false;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public boolean isLoggedIn(){
        return this.isLoggedIn;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tAccount Information\n");
        sb.append("\t");
        sb.append(this.name);
        sb.append("\n");
        sb.append("\t");
        sb.append(this.email);
        sb.append("\n");
        sb.append("\t");
        sb.append(this.phoneNumber);

        return sb.toString();
    }


}
