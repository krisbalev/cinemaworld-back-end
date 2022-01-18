package com.example.individualproject.Service;

import com.example.individualproject.DALInterfaces.IMovieDAL;
import com.example.individualproject.Model.Movie;
import com.example.individualproject.Model.request.MovieCreateRequest;
import com.example.individualproject.Model.request.TrailerCreateRequest;
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

    @Override
    public String returnTrailerByMovieId(int id){
        return this.dal.getTrailer(id);
    }

    @Override
    public boolean addMovie(MovieCreateRequest movieCreateRequest){
        Movie movie = new Movie(movieCreateRequest.getId(),
                                movieCreateRequest.getTitle(),
                                movieCreateRequest.getDescription(),
                                movieCreateRequest.getReleaseDate());
        this.dal.addMovie(movie);
        return true;
    }

    @Override
    public boolean addTrailer(TrailerCreateRequest trailerCreateRequest){
        this.dal.addTrailer(trailerCreateRequest.getMovieId(), trailerCreateRequest.getUrl());
        return true;
    }

    @Override
    public boolean removeMovie(int id){
        this.dal.deleteMovie(id);
        this.dal.deleteTrailer(id);
        return true;
    }

    @Override
    public boolean editMovie(MovieCreateRequest movieCreateRequest){
        Movie movie = new Movie(movieCreateRequest.getId(),
                movieCreateRequest.getTitle(),
                movieCreateRequest.getDescription(),
                movieCreateRequest.getReleaseDate());
        this.dal.editMovie(movie);
        this.dal.editTrailer(movieCreateRequest.getTrailer(), movieCreateRequest.getId());
        return true;
    }
}
