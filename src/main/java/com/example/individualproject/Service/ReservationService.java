package com.example.individualproject.Service;

import com.example.individualproject.DALInterfaces.IReservationDAL;
import com.example.individualproject.Model.Reservation;
import com.example.individualproject.Model.request.ReservationCreateRequest;
import com.example.individualproject.ServiceInterface.IReservation;
import com.example.individualproject.ServiceInterface.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    IReservationDAL dal;

    public ReservationService(IReservationDAL dal){
        this.dal = dal;
    }

    @Override
    public ResponseEntity<List<IReservation>> returnAllReservations(){
        if(dal.getAllReservations() == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(dal.getAllReservations());
        }
    }

    @Override
    public boolean reserve(String username,ReservationCreateRequest reservationCreateRequest){
        Reservation reservation = new Reservation(reservationCreateRequest.getId(),
                                    username,
                                    reservationCreateRequest.getMovieName(),
                                    reservationCreateRequest.getDate(),
                                    reservationCreateRequest.getTime(),
                                    reservationCreateRequest.getNumberOfTickets(),
                                    reservationCreateRequest.getTheatreName());
        dal.reserve(reservation);
        return true;
    }

    @Override
    public ResponseEntity<List<IReservation>> returnReservationsByUser(String username){
        if(dal.getReservationsByUser(username) == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(dal.getReservationsByUser(username));
        }
    }

}
