package com.example.individualproject.Model;

import com.example.individualproject.ServiceInterface.IUser;

public class UserAccount extends Account implements IUser {

    public UserAccount(int id,String username, String password,String email, String firstName, String lastName, String role){
        super(id,username,password,email,firstName,lastName, role);

    }

    public UserAccount(){}
}
