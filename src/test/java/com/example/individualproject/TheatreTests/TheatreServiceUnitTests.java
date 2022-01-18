package com.example.individualproject.TheatreTests;

import com.example.individualproject.DALInterfaces.IMovieDAL;
import com.example.individualproject.DALInterfaces.ITheatreDAL;
import com.example.individualproject.Model.Theatre;
import com.example.individualproject.Model.request.TheatreCreateRequest;
import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.IMovieService;
import com.example.individualproject.ServiceInterface.ITheatre;
import com.example.individualproject.ServiceInterface.ITheatreService;
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
public class TheatreServiceUnitTests {
    @Autowired
    ITheatreService service;

    @MockBean
    ITheatreDAL dal;

    @Test
    public void returnAllTheatres(){
        List<ITheatre> theatres = new ArrayList<>();

        when(dal.getAllTheatres()).thenReturn(theatres);

        Assertions.assertEquals(new ResponseEntity(theatres, HttpStatus.OK), service.returnAllTheatres());
    }

    @Test
    public void returnAllTheatresWhenNull(){
        List<ITheatre> theatres = null;

        when(dal.getAllTheatres()).thenReturn(theatres);

        Assertions.assertEquals(new ResponseEntity(theatres, HttpStatus.NOT_FOUND), service.returnAllTheatres());
    }

    @Test
    public void returnTheatreById(){
        Theatre theatre1 = new Theatre();
        theatre1.getId();
        theatre1.getName();
        theatre1.getAddress();

        ITheatre theatre = new Theatre();
        int id = 1;

        when(dal.getTheatreById(id)).thenReturn(theatre);

        Assertions.assertEquals(new ResponseEntity(theatre, HttpStatus.OK), service.returnTheatreById(id));
    }

    @Test
    public void returnTheatreByIdWhenNull(){
        ITheatre theatre = null;
        int id = 1;

        when(dal.getTheatreById(id)).thenReturn(theatre);

        Assertions.assertEquals(new ResponseEntity(theatre, HttpStatus.NOT_FOUND), service.returnTheatreById(id));
    }

    @Test
    public void addTheatre(){
        TheatreCreateRequest theatreCreateRequest = new TheatreCreateRequest();
        theatreCreateRequest.setId(1);
        theatreCreateRequest.setName("test");
        theatreCreateRequest.setAddress("test");

        Assertions.assertEquals(true, service.addTheatre(theatreCreateRequest));
    }

    @Test
    public void removeTheatre(){
        int id = 1;

        Assertions.assertEquals(true, service.removeTheatre(id));
    }

    @Test
    public void editTheatre(){
        TheatreCreateRequest theatreCreateRequest = new TheatreCreateRequest();

        Assertions.assertEquals(true, service.editTheatre(theatreCreateRequest));
    }

}
