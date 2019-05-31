package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private double movieRating;
    private boolean isCheckedout;


    public Movie(String name, int year, String director, double movieRating){
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

    public double getMovieRating(){
        return this.movieRating;
    }

    public boolean isCheckedout(){
        return this.isCheckedout;
    }

    public boolean Checkout(){
        if (!this.isCheckedout){
            this.isCheckedout = true;
            return true;
        }
        return false;
    }

    public boolean Return(){
        if (this.isCheckedout){
            this.isCheckedout = false;
            return true;
        }
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
