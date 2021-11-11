package com.example.individualproject.Controller;

import com.example.individualproject.Model.request.UserCreateRequest;
import com.example.individualproject.Repository.UserDalJDBC;
import com.example.individualproject.Service.UserService;
import com.example.individualproject.ServiceInterface.IUser;
import com.example.individualproject.ServiceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

    //private IUserService userService = new UserService(new UserDalJDBC());

    @Autowired
    private IUserService userService = new UserService(new UserDalJDBC());

    @GetMapping
    public ResponseEntity<List<IUser>> GetAllUsers()
    {
        return userService.ReturnAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IUser> GetAccountById(@PathVariable(value = "id") int id)
    {
        return userService.ReturnUserByID(id);
    }

    @PostMapping("/register")
    public ResponseEntity UserRegistration(@RequestBody UserCreateRequest userCreateRequest) {

        userService.UserRegistration(userCreateRequest);
        return ResponseEntity.ok().build();
    }

}
