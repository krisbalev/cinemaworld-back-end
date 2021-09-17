package com.example.individualproject.controller;

import com.example.individualproject.model.Movie;
import com.example.individualproject.repository.FakeDataStore;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private static final FakeDataStore fakeDataStore = new FakeDataStore();


    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(value = "name") Optional<String> name) {
        List<Movie> movies = null;

        if (name.isPresent()) {
            movies = fakeDataStore.getMovieByName(name.get());
        } else {
            movies = fakeDataStore.getAllMovies();
        }

        if (movies != null) {
            return ResponseEntity.ok().body(movies);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") int id){
        Movie movie = fakeDataStore.getMovie(id);

        if (movie != null){
            return ResponseEntity.ok().body(movie);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
