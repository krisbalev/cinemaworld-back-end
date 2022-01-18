package com.example.individualproject.MovieTests;

import com.example.individualproject.DALInterfaces.IMovieDAL;
import com.example.individualproject.Model.Movie;
import com.example.individualproject.Model.request.MovieCreateRequest;
import com.example.individualproject.Model.request.TrailerCreateRequest;
import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.IMovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceUnitTests {

    @Autowired
    IMovieService movieService;

    @MockBean
    IMovieDAL dal;

    @Test
    public void returnAllMovies(){
        List<IMovie> movies = new ArrayList<>();

        when(dal.getAllMovies()).thenReturn(movies);

        Assertions.assertEquals(new ResponseEntity(movies, HttpStatus.OK), movieService.returnAllMovies());
    }

    @Test
    public void returnAllMoviesWhenNull(){
        List<IMovie> movies = null;

        when(dal.getAllMovies()).thenReturn(movies);

        Assertions.assertEquals(new ResponseEntity(movies, HttpStatus.NOT_FOUND), movieService.returnAllMovies());
    }

    @Test
    public void returnMovieById(){
        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.getId();
        movie1.setTitle("asd");
        movie1.getTitle();
        movie1.setDescription("asd");
        movie1.getDescription();
        movie1.setReleaseDate(new Date(2001, 01, 10));
        movie1.getReleaseDate();
        IMovie movie = new Movie();
        int id = 1;

        when(dal.getMovieById(id)).thenReturn(movie);

        Assertions.assertEquals(new ResponseEntity(movie, HttpStatus.OK), movieService.returnMovieById(1));
    }

    @Test
    public void returnMovieByIdWhenNull(){
        IMovie movie = null;
        int id = 1;

        when(dal.getMovieById(id)).thenReturn(movie);

        Assertions.assertEquals(new ResponseEntity(movie, HttpStatus.NOT_FOUND), movieService.returnMovieById(1));
    }

    @Test
    public void returnPhotoOfMovieByID(){
        String path = "asd";
        int id = 1;

        when(dal.getPhotoByMovieId(id)).thenReturn(path);

        Assertions.assertEquals("asd", movieService.ReturnPhotoOfMovieByID(id));
    }

    @Test
    public void returnPosterOfMovieById(){
        String path = "asd";
        int id = 1;

        when(dal.getPosterByMovieId(id)).thenReturn(path);

        Assertions.assertEquals("asd", movieService.ReturnPosterOfMovieByID(id));
    }

    @Test
    public void returnTrailerByMovieId(){
        String url = "asd";
        int id = 1;

        when(dal.getTrailer(id)).thenReturn(url);

        Assertions.assertEquals("asd", movieService.returnTrailerByMovieId(id));
    }

    @Test
    public void addMovie(){
        MovieCreateRequest movieCreateRequest = new MovieCreateRequest();
        movieCreateRequest.setId(1);
        movieCreateRequest.setTitle("test");
        movieCreateRequest.setDescription("test");
        movieCreateRequest.setReleaseDate(new Date(2011, 2, 1));



        Assertions.assertEquals(true, movieService.addMovie(movieCreateRequest));

    }

    @Test
    public void addTrailer(){
        TrailerCreateRequest trailerCreateRequest = new TrailerCreateRequest();
        trailerCreateRequest.setMovieId(1);
        trailerCreateRequest.setId(1);
        trailerCreateRequest.getId();
        trailerCreateRequest.setUrl("asd");

        Assertions.assertEquals(true, movieService.addTrailer(trailerCreateRequest));
    }

    @Test
    public void removeMovie(){
        int id = 1;

        Assertions.assertEquals(true, movieService.removeMovie(id));
    }

    @Test
    public void editMovie(){
        MovieCreateRequest movieCreateRequest = new MovieCreateRequest();

        Assertions.assertEquals(true, movieService.editMovie(movieCreateRequest));
    }

}
