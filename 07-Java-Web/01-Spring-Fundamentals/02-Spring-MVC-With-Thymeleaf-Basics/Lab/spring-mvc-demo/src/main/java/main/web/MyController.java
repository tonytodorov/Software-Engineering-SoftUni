package main.web;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class MyController {

    private Map<Integer, String> users = Map.of(
            1, "Hristo",
            2, "Misho",
            3, "Valio"
    );

    @GetMapping("/time")
    public String getTimeNow() {
        return "Time now is " + LocalTime.now();
    }

    @GetMapping("/day")
    public String getDayOfWeek() {
        return "Today is " + LocalDateTime.now().getDayOfWeek().name();
    }


    @GetMapping("/users/{id}")
    public String getUsernameById(@PathVariable int id
//                                  @RequestParam("firstName") String firstName,
//                                  @RequestParam("age") int age
    ) {
        return users.get(id);
    }
}
