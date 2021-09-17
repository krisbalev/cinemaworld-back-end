package com.example.individualproject.model;

public class Movie {
    private String name;
    private String releaseDate;
    private String description;
    private int id;

    public Movie(String name, String release, String description, int id){
        this.name = name;
        this.releaseDate = release;
        this.description = description;
        this.id = id;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getReleaseDate() { return this.releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public int getId() { return this.id; }

    @Override
    public String toString() {
        return "Movie: " + this.name + " released on " + this.description;
    }
}
