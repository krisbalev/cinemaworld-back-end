package com.example.individualproject.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/google")
    public Principal auth(Principal principal) {
       return principal;
    }

    @GetMapping
    public Principal test(Principal principal){
        return principal;
    }
}
