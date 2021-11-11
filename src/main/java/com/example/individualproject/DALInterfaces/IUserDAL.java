package com.example.individualproject.DALInterfaces;

import com.example.individualproject.ServiceInterface.IUser;

import java.util.List;

public interface IUserDAL {
    List<IUser> getAllUsers();
    IUser getUserById(int id);
    IUser getUserByUsername(String username);
    void addUser(IUser user);
}
