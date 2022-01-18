package com.example.individualproject.ReservationTests;

import com.example.individualproject.Controller.ReservationController;
import com.example.individualproject.Model.request.ReservationCreateRequest;
import com.example.individualproject.ServiceInterface.IReservation;
import com.example.individualproject.ServiceInterface.IReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser(username = "johndoe", roles = {"USER"})
public class ReservationControllerTests {

    @Autowired
    ReservationController controller;

    @MockBean
    IReservationService service;

    @Test
    public void getAllReservations(){
        List<IReservation> reservations = new ArrayList<>();

        when(service.returnAllReservations()).thenReturn(new ResponseEntity<List<IReservation>>(reservations, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity<List<IReservation>>(reservations, HttpStatus.OK), controller.getAllReservations());
    }

    @Test
    public void createReservation(){
        ReservationCreateRequest reservationCreateRequest = new ReservationCreateRequest();

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.createReservation(reservationCreateRequest));
    }

    @Test
    public void getReservationsByUser(){
        List<IReservation> reservations = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        when(service.returnReservationsByUser(currentPrincipalName)).thenReturn(new ResponseEntity<List<IReservation>>(reservations, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity<List<IReservation>>(reservations, HttpStatus.OK), controller.getReservationsByUser());
    }



}
