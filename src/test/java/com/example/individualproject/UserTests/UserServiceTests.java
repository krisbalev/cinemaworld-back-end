package com.example.individualproject.UserTests;

import com.example.individualproject.DALInterfaces.ITheatreDAL;
import com.example.individualproject.DALInterfaces.IUserDAL;
import com.example.individualproject.Model.UserAccount;
import com.example.individualproject.Model.request.UserCreateRequest;
import com.example.individualproject.Model.request.UserEditDetailsRequest;
import com.example.individualproject.Service.UserService;
import com.example.individualproject.ServiceInterface.ITheatreService;
import com.example.individualproject.ServiceInterface.IUser;
import com.example.individualproject.ServiceInterface.IUserService;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    UserService service;

    @MockBean
    IUserDAL dal;

    @Test
    public void returnAllUsers(){
        List<IUser> users = new ArrayList<>();

        when(dal.getAllUsers()).thenReturn(users);

        Assertions.assertEquals(new ResponseEntity(users, HttpStatus.OK), service.ReturnAllUsers());
    }

    @Test
    public void returnAllUsersIfNull(){
        List<IUser> users = null;

        when(dal.getAllUsers()).thenReturn(users);

        Assertions.assertEquals(new ResponseEntity(users, HttpStatus.NOT_FOUND), service.ReturnAllUsers());
    }

    @Test
    public void returnUser(){
        IUser user = new UserAccount();
        String username = "username";

        when(dal.getUserByUsername(username)).thenReturn(user);

        Assertions.assertEquals(new ResponseEntity(user, HttpStatus.OK), service.ReturnUserByUsername(username));
    }

    @Test
    public void returnUserNull(){
        IUser user = null;
        String username = "username";

        when(dal.getUserByUsername(username)).thenReturn(user);

        Assertions.assertEquals(new ResponseEntity(user, HttpStatus.NOT_FOUND), service.ReturnUserByUsername(username));
    }

    @Test
    public void returnUserById(){
        int id = 1;
        IUser user = new UserAccount();

        when(dal.getUserById(id)).thenReturn(user);

        Assertions.assertEquals(new ResponseEntity<IUser>(user, HttpStatus.OK), service.ReturnUserByID(id));
    }

    @Test
    public void returnUserByIdWhenNull(){
        int id = 1;
        IUser user = null;

        when(dal.getUserById(id)).thenReturn(user);

        Assertions.assertEquals(new ResponseEntity<IUser>(user, HttpStatus.NOT_FOUND), service.ReturnUserByID(id));

    }

    @Test
    public void getUserByUsername(){
         IUser user = new UserAccount();
         String username = "test";

         when(dal.getUserByUsername(username)).thenReturn(user);

         Assertions.assertEquals(user, service.GetUserByUsername(username));
    }

    @Test
    public void editUserDetails(){
        String username = "test";
        UserEditDetailsRequest userEditDetailsRequest = new UserEditDetailsRequest();
        IUser user = new UserAccount();
        int id = 1;
        user.setId(id);
        userEditDetailsRequest.setEmail("test");
        userEditDetailsRequest.setFirstName("test");
        userEditDetailsRequest.setLastName("test");

        when(dal.getUserByUsername(username)).thenReturn(user);

        Assertions.assertEquals(true, service.EditUserDetails(username, userEditDetailsRequest));
    }

    @Test
    public void userRegistration(){
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        IUser user = new UserAccount();
        userCreateRequest.setId(1);
        userCreateRequest.setUsername("test");
        userCreateRequest.setPassword("test");
        userCreateRequest.setEmail("test");
        userCreateRequest.setFirstName("test");
        userCreateRequest.setLastName("test");
        userCreateRequest.setRole("teeeest");

        when(dal.addUser(user)).thenReturn(true);

        Assertions.assertEquals(true, service.UserRegistration(userCreateRequest));
    }
}
