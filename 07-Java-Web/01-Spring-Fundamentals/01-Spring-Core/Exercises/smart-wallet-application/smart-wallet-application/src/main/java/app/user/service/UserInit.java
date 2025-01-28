package app.user.service;

import app.user.model.Country;
import app.web.dto.MyUserRecord;
import app.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInit implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public UserInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!userService.getAllUsers().isEmpty()) {
            return;
        }

        MyUserRecord myUserRecord = new MyUserRecord("Jik", 24);

        RegisterRequest registerRequest = RegisterRequest.builder()
                .username("Test123")
                .password("123123")
                .country(Country.BULGARIA)
                .build();

        userService.register(registerRequest);
    }
}
