package com.example.individualproject.Model;

import com.example.individualproject.ServiceInterface.ITheatre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theatre implements ITheatre {

    private int id;
    private String name;
    private String address;

    public Theatre(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Theatre(){}
}
