package com.example.individualproject.AdminTests;
import com.example.individualproject.Controller.AdminController;
import com.example.individualproject.Model.request.MovieCreateRequest;
import com.example.individualproject.Model.request.TheatreCreateRequest;
import com.example.individualproject.Model.request.TrailerCreateRequest;
import com.example.individualproject.ServiceInterface.IMovieService;
import com.example.individualproject.ServiceInterface.ITheatreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTests {

    @Autowired
    AdminController controller;

    @MockBean
    IMovieService movieService;

    @MockBean
    ITheatreService theatreService;

    @Test
    public void addMovie(){
        MovieCreateRequest movieCreateRequest = new MovieCreateRequest();

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.addMovie(movieCreateRequest));
    }

    @Test
    public void addTrailer(){
        TrailerCreateRequest trailerCreateRequest = new TrailerCreateRequest();

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.addTrailer(trailerCreateRequest));
    }

    @Test
    public void addTheatre(){
        TheatreCreateRequest theatreCreateRequest = new TheatreCreateRequest();

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.addTheatre(theatreCreateRequest));
    }

    @Test
    public void removeMovie(){
        int id = 1;

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.removeMovie(id));
    }

    @Test
    public void removeTheatre(){
        int id = 1;

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.removeTheatre(id));
    }

    @Test
    public void editTheatre(){
        TheatreCreateRequest theatreCreateRequest = new TheatreCreateRequest();

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.editTheatre(theatreCreateRequest));
    }

    @Test
    public void editMovie(){
        MovieCreateRequest movieCreateRequest = new MovieCreateRequest();

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.editMovie(movieCreateRequest));
    }




}
