package com.example.individualproject.Controller;

import com.example.individualproject.Model.request.UserCreateRequest;
import com.example.individualproject.Model.request.UserEditDetailsRequest;
import com.example.individualproject.Repository.UserDalJDBC;
import com.example.individualproject.Service.UserService;
import com.example.individualproject.ServiceInterface.IUser;
import com.example.individualproject.ServiceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService = new UserService(new UserDalJDBC());

    @GetMapping
    public ResponseEntity<List<IUser>> GetAllUsers()
    {
        return userService.ReturnAllUsers();
    }

    @GetMapping("/account")
    public ResponseEntity<IUser> GetAccountByUsername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return userService.ReturnUserByUsername(currentPrincipalName);
    }

    @PostMapping("/register")
    public ResponseEntity UserRegistration(@RequestBody UserCreateRequest userCreateRequest) {

        userService.UserRegistration(userCreateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit-details")
    public ResponseEntity EditUserDetails(@RequestBody UserEditDetailsRequest userEditDetailsRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        userService.EditUserDetails(currentPrincipalName, userEditDetailsRequest);
        return ResponseEntity.ok().build();
    }

}
