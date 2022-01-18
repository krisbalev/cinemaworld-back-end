package com.example.individualproject.ServiceInterface;

import com.example.individualproject.Model.request.TheatreCreateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITheatreService {
    ResponseEntity<List<ITheatre>> returnAllTheatres();
    ResponseEntity<ITheatre> returnTheatreById(int id);
    boolean addTheatre(TheatreCreateRequest theatreCreateRequest);
    boolean removeTheatre(int id);
    boolean editTheatre(TheatreCreateRequest theatreCreateRequest);
}
