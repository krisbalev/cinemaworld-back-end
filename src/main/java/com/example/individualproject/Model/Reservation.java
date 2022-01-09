package com.example.individualproject.Model;

import com.example.individualproject.ServiceInterface.IReservation;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Reservation implements IReservation {

    private int id;
    private String username;
    private String movieName;
    private String theatreName;
    private Date date;
    private Time time;
    private int numberOfTickets;

    public Reservation(int id, String username, String movieName, Date date, Time time, int numberOfTickets, String theatreName){
        this.id = id;
        this.username = username;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.numberOfTickets = numberOfTickets;
        this.theatreName = theatreName;
    }

    public Reservation(){}

}
