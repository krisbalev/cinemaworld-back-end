package com.example.individualproject.ServiceInterface;

import com.example.individualproject.Model.request.UserCreateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<IUser> ReturnUserByID(int id);
    void UserRegistration(UserCreateRequest userCreateRequest);
    ResponseEntity<List<IUser>>ReturnAllUsers();
}
