package com.example.individualproject.Service;


import com.example.individualproject.DALInterfaces.ITheatreDAL;
import com.example.individualproject.ServiceInterface.ITheatre;
import com.example.individualproject.ServiceInterface.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService implements ITheatreService {

    @Autowired
    ITheatreDAL dal;


    public TheatreService(ITheatreDAL dal){ this.dal = dal;}

    public ResponseEntity<List<ITheatre>> returnAllTheatres(){
        if (dal.getAllTheatres() == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(dal.getAllTheatres());
        }
    }

    public ResponseEntity<ITheatre> returnTheatreById(int id){
        ITheatre theatre = dal.getTheatreById(id);
        if (theatre == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(theatre);
        }
    }
}
