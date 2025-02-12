package main.web;

import main.model.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestRestController {

    private final UserService userService;

    @Autowired
    public TestRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/date")
    public String getDate() {
        return "Date is " + LocalDateTime.now().getDayOfWeek();
    }

    @GetMapping("/hour")
    public String getHours() {
        return "Time is " + LocalDateTime.now().getHour();
    }

    @GetMapping("/hour/{hours}")
    public String setHours(@PathVariable int hours) {
        if (hours < 0 || hours > 23) {
            return "Invalid hours";
        }

        return "Time is " + hours;
    }

    @GetMapping("/allUsers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
