package app.web;

import app.user.model.User;
import app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class IndexController {

    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "my-page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/home")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView();

        User userById = userService.getById(UUID.fromString("0dbf6c0a-b381-4069-94cc-2597df0378b8"));

        modelAndView.setViewName("home");
        modelAndView.addObject("user", userById);

        return modelAndView;
    }
}
