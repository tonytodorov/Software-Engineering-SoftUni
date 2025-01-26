package app.web;

import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String getIndexPage() {
        return "my-page";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest", new RegisterRequest());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerNewUser(RegisterRequest registerRequest) {


        System.out.println(registerRequest);

        return null;
    }

    @GetMapping("/home")
    public ModelAndView getHomePage() {

        ModelAndView modelAndView = new ModelAndView();

        User userById = userService.getById(UUID.fromString("0dbf6c0a-b381-4069-94cc-2597df0378b8"));

        modelAndView.setViewName("home");
        modelAndView.addObject("user", userById);

        return modelAndView;
    }
}
