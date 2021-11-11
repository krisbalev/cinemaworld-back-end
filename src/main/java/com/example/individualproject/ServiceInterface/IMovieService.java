package com.example.individualproject.ServiceInterface;

import com.example.individualproject.Model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    ResponseEntity<List<IMovie>> returnAllMovies();
    ResponseEntity<IMovie> returnMovieById (int id);
}
