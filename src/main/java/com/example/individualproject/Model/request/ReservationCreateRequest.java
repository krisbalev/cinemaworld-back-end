package com.example.individualproject.Model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@Data
public class ReservationCreateRequest {
    private int id;
    private String movieName;
    private String theatreName;
    private Date date;
    private Time time;
    private int numberOfTickets;
}
