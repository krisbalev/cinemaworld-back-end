//package com.example.individualproject.UserTests;
//
//import com.example.individualproject.Controller.UserController;
//import com.example.individualproject.Model.UserAccount;
//import com.example.individualproject.Model.request.UserCreateRequest;
//import com.example.individualproject.ServiceInterface.IUser;
//import com.example.individualproject.ServiceInterface.IUserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WithMockUser(username = "user", roles = {"USER"})
//public class UserControllerTests {
//
//    @Autowired
//    UserController controller;
//
//    @MockBean
//    IUserService service;
//
//    @Test
//    public void getAllUsers(){
//        List<IUser> users = new ArrayList<>();
//
//        when(service.ReturnAllUsers()).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));
//
//        Assertions.assertEquals(new ResponseEntity<>(users, HttpStatus.OK), controller.GetAllUsers());
//    }
//
//    @Test
//    public void getAccount(){
//        IUser user = new UserAccount();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//
//        when(service.ReturnUserByUsername(currentPrincipalName)).thenReturn(new ResponseEntity<IUser>(user, HttpStatus.OK));
//
//        Assertions.assertEquals(new ResponseEntity<IUser>(user, HttpStatus.OK), controller.GetAccountByUsername());
//    }
//
//    @Test
//    public void userRegistration(){
//        UserCreateRequest userCreateRequest = new UserCreateRequest();
//
//        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK), controller.UserRegistration(userCreateRequest));
//    }
//
//}
