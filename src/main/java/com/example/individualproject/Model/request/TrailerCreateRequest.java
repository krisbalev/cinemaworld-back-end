package com.example.individualproject.Model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrailerCreateRequest {
    private int id;
    private int movieId;
    private String url;
}
