package com.example.individualproject.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Account {

    protected int id;
    protected String username;
    protected String password;
    protected String email;
    protected String firstName;
    protected String lastName;

    public  Account() {

    }

    public Account(int id,String username, String password,String email, String fName,String lName)
    {
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.firstName=fName;
        this.lastName=lName;

    }

}
