package main.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class TestRestPostController {

    @PostMapping("/user")
    public String createUser() {
        return "Created user!";
    }
}
