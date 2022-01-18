package com.example.individualproject.Service;


import com.example.individualproject.DALInterfaces.ITheatreDAL;
import com.example.individualproject.Model.Theatre;
import com.example.individualproject.Model.request.TheatreCreateRequest;
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

    @Override
    public ResponseEntity<List<ITheatre>> returnAllTheatres(){
        if (dal.getAllTheatres() == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(dal.getAllTheatres());
        }
    }

    @Override
    public ResponseEntity<ITheatre> returnTheatreById(int id){
        ITheatre theatre = dal.getTheatreById(id);
        if (theatre == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(theatre);
        }
    }

    @Override
    public boolean addTheatre(TheatreCreateRequest theatreCreateRequest){
        Theatre theatre = new Theatre(theatreCreateRequest.getId(), theatreCreateRequest.getName(), theatreCreateRequest.getAddress());

        this.dal.addTheatre(theatre);
        return true;
    }

    @Override
    public boolean removeTheatre(int id){

        this.dal.deleteTheatre(id);
        return true;
    }

    @Override
    public boolean editTheatre(TheatreCreateRequest theatreCreateRequest){
        Theatre theatre = new Theatre(theatreCreateRequest.getId(), theatreCreateRequest.getName(), theatreCreateRequest.getAddress());

        this.dal.editTheatre(theatre);
        return true;
    }
}
