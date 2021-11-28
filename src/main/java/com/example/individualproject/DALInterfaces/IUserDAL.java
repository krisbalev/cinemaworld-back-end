package com.example.individualproject.DALInterfaces;

import com.example.individualproject.ServiceInterface.IUser;

import java.util.List;

public interface IUserDAL {
    List<IUser> getAllUsers();
    IUser getUserById(int id);
    IUser getUserByUsername(String username);
    boolean addUser(IUser user);
    void editUserDetails(int id, String email, String firstName, String lastName);
}
