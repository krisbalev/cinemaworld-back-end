package com.example.individualproject.ServiceInterface;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITheatreService {
    ResponseEntity<List<ITheatre>> returnAllTheatres();
    ResponseEntity<ITheatre> returnTheatreById(int id);
}
