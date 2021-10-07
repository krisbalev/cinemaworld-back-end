package com.example.individualproject.repository;

import com.example.individualproject.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FakeDataStore {
    private final List<Movie> movieList = new ArrayList<>();

    public FakeDataStore(){
        Movie venom = new Movie("Venom", "04.10.2018", "dummy desc", 1);
        Movie avengers = new Movie("Avengers", "23.04.2012", "dummy desc", 2);
        Movie split = new Movie("Split","26.09.2016", "dummy desc", 3);

        movieList.add(venom);
        movieList.add(avengers);
        movieList.add(split);
    }

    public List<Movie> getAllMovies(){ return this.movieList; }

    public List<Movie> getMovieByTitle(String name) {
        List<Movie> filtered = new ArrayList<>();
        for (Movie m : movieList) {
            if (m.getTitle().equals(name)) {
                filtered.add(m);
            }
        }
        return filtered;
    }
    
    public List<Movie> getMoviesByRelease(String releaseDate){
        List<Movie> filtered = new ArrayList<>();
        for (Movie m : movieList){
            if (m.getReleaseDate().equals(releaseDate)){
                filtered.add(m);
            }
        }
        return filtered;
    }

    public List<Movie> getMovieById(int id){
        List<Movie> filtered = new ArrayList<>();
        for (Movie m : movieList) {
            if (m.getId() == id) {
                filtered.add(m);
            }
        }
        return filtered;
    }

    public Movie getMovie(int id){
        for (Movie m : movieList){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }
}
