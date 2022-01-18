package com.example.individualproject.Controller;

import com.example.individualproject.Model.request.MovieCreateRequest;
import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    @GetMapping("/photo/{id}")
    public ResponseEntity<Resource> GetPhotoMovieById(@PathVariable(value = "id") int id)
    {
        String filename =  movieService.ReturnPhotoOfMovieByID(id);

        ByteArrayResource inputStream = null;

        try{
            String direcotry = new File("./" ).getCanonicalPath() + "/photos/" + filename;

            inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                    direcotry)));
            return ResponseEntity.ok()
                    .contentLength(inputStream.contentLength())
                    .body(inputStream);
        }
        catch (Exception e){ e.getMessage(); }

        return ResponseEntity.notFound().build();


    }

    @GetMapping("/poster/{id}")
    public ResponseEntity<Resource> GetPosterMovieById(@PathVariable(value = "id") int id)
    {
        String filename =  movieService.ReturnPosterOfMovieByID(id);

        ByteArrayResource inputStream = null;

        try{
            String direcotry = new File("./" ).getCanonicalPath() + "/photos/" + filename;

            inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                    direcotry)));
            return ResponseEntity.ok()
                    .contentLength(inputStream.contentLength())
                    .body(inputStream);

        }
        catch (Exception e){ e.getMessage(); }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/trailer/{id}")
    public String getTrailerByMovieId(@PathVariable(value = "id") int id){
        return this.movieService.returnTrailerByMovieId(id);
    }

}
