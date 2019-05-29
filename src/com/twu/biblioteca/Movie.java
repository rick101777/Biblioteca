package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int movieRating;
    private boolean isCheckedout;


    public Movie(String name, int year, String director, int movieRating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.isCheckedout = false;
    }


    public String getName(){
        return this.name;
    }

    public int getYear(){
        return this.year;
    }

    public String getDirector(){
        return this.director;
    }

    public int getMovieRating(){
        return this.movieRating;
    }

    public boolean Checkout(){
        //TODO
        return false;
    }

    public boolean Return(){
        //TODO
        return false;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("\t|\t");
        sb.append(this.year);
        sb.append("\t|\t");
        sb.append(this.director);
        sb.append("\t|\t");
        sb.append((this.movieRating == -1) ? "unrated" : this.movieRating);
        return sb.toString();
    }

}
