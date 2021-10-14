package com.example.individualproject.Model;

import com.example.individualproject.ServiceInterface.IMovie;

public class Movie implements IMovie {
    private String title;
    private String releaseDate;
    private String description;
    private int id;

    public Movie(String title, String release, String description, int id){
        this.title = title;
        this.releaseDate = release;
        this.description = description;
        this.id = id;
    }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getReleaseDate() { return this.releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public int getId() { return this.id; }

    @Override
    public String toString() {
        return "Movie: " + this.title + " released on " + this.description;
    }
}
