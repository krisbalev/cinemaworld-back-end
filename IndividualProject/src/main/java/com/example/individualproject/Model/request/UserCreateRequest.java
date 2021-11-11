package com.example.individualproject.Model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class UserCreateRequest {

    protected int id;
    protected   String username;
    protected   String password;
    protected   String email;
    protected   String firstName;
    protected   String lastName;

}
