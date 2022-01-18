package com.example.individualproject.Controller;

import com.example.individualproject.Model.Theatre;
import com.example.individualproject.Model.request.MovieCreateRequest;
import com.example.individualproject.Model.request.TheatreCreateRequest;
import com.example.individualproject.Model.request.TrailerCreateRequest;
import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.IMovieService;
import com.example.individualproject.ServiceInterface.ITheatre;
import com.example.individualproject.ServiceInterface.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IMovieService movieService;

    @Autowired
    private ITheatreService theatreService;

    @PostMapping("/add/movie")
    public ResponseEntity<IMovie> addMovie(@RequestBody MovieCreateRequest movieCreateRequest) {
        this.movieService.addMovie(movieCreateRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add/trailer")
    public ResponseEntity<IMovie> addTrailer(@RequestBody TrailerCreateRequest trailerCreateRequest) {
        this.movieService.addTrailer(trailerCreateRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add/theatre")
    public ResponseEntity<ITheatre> addTheatre(@RequestBody TheatreCreateRequest theatreCreateRequest) {
        this.theatreService.addTheatre(theatreCreateRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove/movie/{id}")
    public ResponseEntity removeMovie(@PathVariable(value = "id") int id){
        this.movieService.removeMovie(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove/theatre/{id}")
    public ResponseEntity removeTheatre(@PathVariable(value = "id") int id){
        this.theatreService.removeTheatre(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit/movie")
    public ResponseEntity editMovie(@RequestBody MovieCreateRequest movieCreateRequest){
        this.movieService.editMovie(movieCreateRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit/theatre")
    public ResponseEntity editTheatre(@RequestBody TheatreCreateRequest theatreCreateRequest){
        this.theatreService.editTheatre(theatreCreateRequest);

        return ResponseEntity.ok().build();
    }

}
