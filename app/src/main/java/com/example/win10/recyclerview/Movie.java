package com.example.win10.recyclerview;

/**
 * Created by WIN10 on 11/03/2017.
 */

public class Movie {

    private String title, director, genre, year;

    public Movie(String title, String director, String genre, String year) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
