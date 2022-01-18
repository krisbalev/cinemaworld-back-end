package com.example.individualproject.MovieTests;
import com.example.individualproject.Controller.MoviesController;
import com.example.individualproject.Model.Movie;
import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.IMovieService;
import com.nimbusds.jose.util.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerTests {

    @Autowired
    MoviesController moviesController;

    @MockBean
    IMovieService movieService;

    @Test
    public void getAllMovies(){
        List<IMovie> movies = new ArrayList<>();

        when(movieService.returnAllMovies()).thenReturn(new ResponseEntity<List<IMovie>>(movies, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity<List<IMovie>>(movies, HttpStatus.OK), moviesController.getAllMovies());
    }

    @Test
    public void getMovieById(){
        int id = 1;
        IMovie movie = new Movie();

        when(movieService.returnMovieById(id)).thenReturn(new ResponseEntity<IMovie>(movie, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity<IMovie>(movie, HttpStatus.OK), moviesController.getMovieById(id));
    }

//    @Test
//    public void getPhotoById(){
//        int id = 1;
//        String path = "asd";
//
//        when(movieService.ReturnPhotoOfMovieByID(id)).thenReturn(path);
//
//        Assertions.assertEquals(new ResponseEntity(path, HttpStatus.OK), moviesController.GetPhotoMovieById(id));
//    }

    @Test
    public void getTrailerByMovieId(){
        int id = 1;
        String url = "asd";

        when(movieService.returnTrailerByMovieId(id)).thenReturn(url);

        Assertions.assertEquals(url, moviesController.getTrailerByMovieId(id));
    }

}
