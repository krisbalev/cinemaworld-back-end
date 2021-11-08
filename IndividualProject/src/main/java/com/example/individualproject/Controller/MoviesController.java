package com.example.individualproject.Controller;

import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private IMovieService movieService;


    @GetMapping
    public ResponseEntity<List<IMovie>> getAllMovies() {
       return this.movieService.returnAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IMovie> getMovieById(@PathVariable(value = "id") int id){
        return this.movieService.returnMovieById(id);
    }

}
