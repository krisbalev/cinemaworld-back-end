package com.example.individualproject.DALInterfaces;

import com.example.individualproject.ServiceInterface.IMovie;

import java.util.List;

public interface IMovieDAL {
    List<IMovie> getAllMovies();
    IMovie getMovieById(int id);
    String getPhotoByMovieId(int id);
}
