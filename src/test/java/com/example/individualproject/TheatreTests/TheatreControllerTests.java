package com.example.individualproject.TheatreTests;
import com.example.individualproject.Controller.TheatreController;
import com.example.individualproject.DALInterfaces.ITheatreDAL;
import com.example.individualproject.Model.Theatre;
import com.example.individualproject.ServiceInterface.ITheatre;
import com.example.individualproject.ServiceInterface.ITheatreService;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheatreControllerTests {

    @Autowired
    TheatreController theatreController;

    @MockBean
    ITheatreService service;

    @Test
    public void getAllTheatres(){
        List<ITheatre> theatres = new ArrayList<>();

        when(service.returnAllTheatres()).thenReturn(new ResponseEntity(theatres, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity(theatres, HttpStatus.OK), theatreController.getAllTheatres());
    }

    @Test
    public void getTheatreById(){
        int id = 1;
        ITheatre theatre = new Theatre();

        when(service.returnTheatreById(id)).thenReturn(new ResponseEntity(theatre, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity(theatre, HttpStatus.OK), theatreController.getTheatreById(id));

    }
}
