package com.example.individualproject.Controller;

import com.example.individualproject.Model.request.ReservationCreateRequest;
import com.example.individualproject.ServiceInterface.IReservation;
import com.example.individualproject.ServiceInterface.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    public IReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<IReservation>> getAllReservations() { return this.reservationService.returnAllReservations(); }

    @PostMapping("/reserve")
    public ResponseEntity createReservation(@RequestBody ReservationCreateRequest reservationCreateRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        reservationService.reserve(currentPrincipalName,reservationCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<IReservation>> getReservationsByUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return reservationService.returnReservationsByUser(currentPrincipalName);
    }
}
