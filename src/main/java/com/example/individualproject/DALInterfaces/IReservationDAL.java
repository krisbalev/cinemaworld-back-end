package com.example.individualproject.DALInterfaces;

import com.example.individualproject.Model.Reservation;
import com.example.individualproject.ServiceInterface.IReservation;

import java.util.List;

public interface IReservationDAL {
    List<IReservation> getAllReservations();
    void reserve(Reservation reservation);
    List<IReservation> getReservationsByUser(String username);
}
