package com.example.individualproject.Model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreCreateRequest {
    private int id;
    private String name;
    private String address;
}
