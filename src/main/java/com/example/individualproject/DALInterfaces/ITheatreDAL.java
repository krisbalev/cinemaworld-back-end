package com.example.individualproject.DALInterfaces;

import com.example.individualproject.ServiceInterface.ITheatre;

import java.util.List;

public interface ITheatreDAL {
    List<ITheatre> getAllTheatres();
    ITheatre getTheatreById(int id);
}
