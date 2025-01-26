package com.example.spring_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final UserService userService;

    @Autowired
    public OrderService(UserService userService) {
        this.userService = userService;
    }

    public void makeOrder() {
        System.out.printf("Sending order to: %s%n", userService.getUserHomeAddress());
    }
}
