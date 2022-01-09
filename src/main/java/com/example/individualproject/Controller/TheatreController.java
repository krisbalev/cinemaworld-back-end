package com.example.individualproject.Controller;


import com.example.individualproject.ServiceInterface.ITheatre;
import com.example.individualproject.ServiceInterface.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private ITheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<ITheatre>> getAllTheatres() { return this.theatreService.returnAllTheatres(); }

    @GetMapping("/{id}")
    public ResponseEntity<ITheatre> getTheatreById(@PathVariable(value = "id") int id){
        return this.theatreService.returnTheatreById(id);
    }
}
