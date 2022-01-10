package com.example.individualproject.Service;

import com.example.individualproject.DALInterfaces.IMovieDAL;
import com.example.individualproject.Model.Movie;
import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieDAL dal;

    public MovieService(IMovieDAL dal){
        this.dal = dal;
    }

    public ResponseEntity<List<IMovie>> returnAllMovies() {
        if(dal.getAllMovies() == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok().body(dal.getAllMovies());
        }


    }

    public ResponseEntity<IMovie> returnMovieById(int id) {
        IMovie movie = dal.getMovieById(id);
        if (movie == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok().body(movie);
        }
    }

    @Override
    public String ReturnPhotoOfMovieByID(int id)
    {
        String path = dal.getPhotoByMovieId(id);
        return path;
    }

    @Override
    public String ReturnPosterOfMovieByID(int id)
    {
        String path = dal.getPosterByMovieId(id);
        return path;
    }

}
