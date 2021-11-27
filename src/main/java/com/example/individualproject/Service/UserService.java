package com.example.individualproject.Service;

import com.example.individualproject.DALInterfaces.IUserDAL;
import com.example.individualproject.Model.UserAccount;
import com.example.individualproject.Model.request.UserCreateRequest;
import com.example.individualproject.ServiceInterface.IUser;
import com.example.individualproject.ServiceInterface.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserDAL dal;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public ResponseEntity<List<IUser>> ReturnAllUsers()
    {
        if (dal.getAllUsers() == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok().body(dal.getAllUsers());
        }

    }

    public IUser GetUserByUsername(String username) {
        return dal.getUserByUsername(username);
    }

    @Override
    public ResponseEntity<IUser> ReturnUserByUsername(String username){
        IUser account = dal.getUserByUsername(username);
        if (account == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok().body(account);
        }
    }

    @Override
    public ResponseEntity<IUser> ReturnUserByID(int id) {
        IUser account = dal.getUserById(id);
        if (account == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(account);
        }
    }


    @Override
    public boolean UserRegistration(UserCreateRequest userCreateRequest) {
        IUser user;
        Optional<IUser> byUsername = Optional.ofNullable(dal.getUserByUsername(userCreateRequest.getUsername()));
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user = new UserAccount(userCreateRequest.getId(),
                userCreateRequest.getUsername(),
                passwordEncoder.encode(userCreateRequest.getPassword()),
                userCreateRequest.getEmail(),
                userCreateRequest.getFirstName(),
                userCreateRequest.getLastName());
        dal.addUser(user);
        return true;
    }
}