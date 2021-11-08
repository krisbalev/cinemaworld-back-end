package com.example.individualproject.Model;

import com.example.individualproject.ServiceInterface.IMovie;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

public class Movie implements IMovie {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private Date releaseDate;

    @Getter @Setter
    private String description;

    public Movie(int id,String title, String description, Date releaseDate){
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie: " + this.title + " released on " + this.description;
    }
}
