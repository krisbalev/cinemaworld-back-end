package com.example.individualproject.DALInterfaces;

import com.example.individualproject.Model.Movie;
import com.example.individualproject.ServiceInterface.IMovie;

import java.util.List;

public interface IMovieDAL {
    List<IMovie> getAllMovies();
    IMovie getMovieById(int id);
    String getPhotoByMovieId(int id);
    String getPosterByMovieId(int id);
    String getTrailer(int id);
    void addMovie(Movie movie);
    void addTrailer(int movieId,String trailer);
    void deleteMovie(int id);
    void deleteTrailer(int id);
    void editMovie(Movie movie);
    void editTrailer(String url, int id);
}
