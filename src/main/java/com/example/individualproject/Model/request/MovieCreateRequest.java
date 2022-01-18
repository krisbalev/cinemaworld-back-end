package com.example.individualproject.Model.request;

import com.example.individualproject.Model.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class MovieCreateRequest {
    private int id;
    private String title;
    private Date releaseDate;
    private String description;
    private String trailer;
}
