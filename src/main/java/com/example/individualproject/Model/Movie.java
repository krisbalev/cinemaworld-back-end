/**
 * @author Kristiyan Balev
 */

package com.example.individualproject.Model;

import com.example.individualproject.ServiceInterface.IMovie;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
public class Movie implements IMovie {

    private int id;
    private String title;
    private Date releaseDate;
    private String description;

    public Movie(int id,String title, String description, Date releaseDate){
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
        this.id = id;
    }

    public Movie() {}
}
