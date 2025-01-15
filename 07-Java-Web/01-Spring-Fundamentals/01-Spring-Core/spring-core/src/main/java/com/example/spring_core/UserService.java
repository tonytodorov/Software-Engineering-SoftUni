package com.example.spring_core;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserHomeAddress() {
        return "Sofia, Borovo";
    }
}
