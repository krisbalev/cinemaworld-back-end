package com.example.individualproject.ReservationTests;

import com.example.individualproject.DALInterfaces.IReservationDAL;
import com.example.individualproject.DALInterfaces.ITheatreDAL;
import com.example.individualproject.Model.Reservation;
import com.example.individualproject.Model.request.ReservationCreateRequest;
import com.example.individualproject.ServiceInterface.IReservation;
import com.example.individualproject.ServiceInterface.IReservationService;
import com.example.individualproject.ServiceInterface.ITheatreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceUnitTests {
    @Autowired
    IReservationService service;

    @MockBean
    IReservationDAL dal;

    @Test
    public void returnAllReservations(){
        List<IReservation> reservations = new ArrayList<>();

        when(dal.getAllReservations()).thenReturn(reservations);

        Assertions.assertEquals(new ResponseEntity(reservations, HttpStatus.OK), service.returnAllReservations());
    }

    @Test
    public void returnAllReservationsWhenNull(){
        List<IReservation> reservations = null;

        when(dal.getAllReservations()).thenReturn(reservations);

        Assertions.assertEquals(new ResponseEntity(reservations, HttpStatus.NOT_FOUND), service.returnAllReservations());
    }

    @Test
    public void returnReservationById(){
        List<IReservation> reservations = new ArrayList<>();
        String username = "username";

        when(dal.getReservationsByUser(username)).thenReturn(reservations);

        Assertions.assertEquals(new ResponseEntity(reservations, HttpStatus.OK), service.returnReservationsByUser(username));
    }

    @Test
    public void returnReservationByIdWhenNull(){
        List<IReservation> reservations = null;
        String username = "username";

        when(dal.getReservationsByUser(username)).thenReturn(reservations);

        Assertions.assertEquals(new ResponseEntity(reservations, HttpStatus.NOT_FOUND), service.returnReservationsByUser(username));
    }


    @Test
    public void reserve(){
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.getId();
        reservation.setUsername("aasd");
        reservation.getUsername();
        reservation.setMovieName("asd");
        reservation.getMovieName();
        reservation.setTheatreName("asd");
        reservation.getTheatreName();
        reservation.setDate(new Date(3102, 12, 01));
        reservation.getDate();
        reservation.setTime(new Time(21, 21, 21));
        reservation.getTime();
        reservation.setNumberOfTickets(2);
        reservation.getNumberOfTickets();

        String username = "test";
        ReservationCreateRequest reservationCreateRequest = new ReservationCreateRequest();
        reservationCreateRequest.setId(1);
        reservationCreateRequest.setMovieName("test");
        reservationCreateRequest.setTheatreName("test");
        reservationCreateRequest.setDate(new Date(2001, 01, 01));
        reservationCreateRequest.setTime(new Time(21, 00, 00));
        reservationCreateRequest.setNumberOfTickets(4);

        Assertions.assertEquals(true, service.reserve(username, reservationCreateRequest));
    }


}
