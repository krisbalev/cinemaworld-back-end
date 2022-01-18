package com.example.individualproject.ServiceInterface;

import com.example.individualproject.Model.Movie;
import com.example.individualproject.Model.request.MovieCreateRequest;
import com.example.individualproject.Model.request.TrailerCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    ResponseEntity<List<IMovie>> returnAllMovies();
    ResponseEntity<IMovie> returnMovieById (int id);
    String ReturnPhotoOfMovieByID(int id);
    String ReturnPosterOfMovieByID(int id);
    String returnTrailerByMovieId(int id);
    boolean addMovie(MovieCreateRequest movieCreateRequest);
    boolean addTrailer(TrailerCreateRequest trailerCreateRequest);
    boolean removeMovie(int id);
    boolean editMovie(MovieCreateRequest movieCreateRequest);
}
