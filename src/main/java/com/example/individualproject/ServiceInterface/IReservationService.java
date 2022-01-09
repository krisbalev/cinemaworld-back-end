package com.example.individualproject.ServiceInterface;

import com.example.individualproject.Model.request.ReservationCreateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReservationService {
    ResponseEntity<List<IReservation>> returnAllReservations();
    void reserve(String username,ReservationCreateRequest reservationCreateRequest);
    ResponseEntity<List<IReservation>> returnReservationsByUser(String username);
}
