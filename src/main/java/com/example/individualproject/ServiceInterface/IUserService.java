package com.example.individualproject.ServiceInterface;

import com.example.individualproject.Model.request.UserCreateRequest;
import com.example.individualproject.Model.request.UserEditDetailsRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<IUser> ReturnUserByID(int id);
    ResponseEntity<IUser> ReturnUserByUsername(String username);
    boolean UserRegistration(UserCreateRequest userCreateRequest);
    ResponseEntity<List<IUser>>ReturnAllUsers();
    boolean EditUserDetails(String username, UserEditDetailsRequest userEditDetailsRequest);

}
