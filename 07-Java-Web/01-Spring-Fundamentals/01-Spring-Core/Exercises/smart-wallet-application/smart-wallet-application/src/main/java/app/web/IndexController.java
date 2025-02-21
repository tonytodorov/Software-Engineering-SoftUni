package app.web;

import app.security.AuthenticationDetails;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView getLoginPage(@RequestParam(value = "error", required = false) String error) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginRequest", new LoginRequest());

        if (error != null) {
            modelAndView.addObject("errorMessage", "Incorrect username or password.");
        }

        return modelAndView;
    }

//    @PostMapping("/login")
//    public ModelAndView loginUser(@Valid LoginRequest loginRequest, BindingResult bindingResult, HttpSession session) {
//
//        if (bindingResult.hasErrors()) {
//            return new ModelAndView("login");
//        }
//
//        User loggedInUser = userService.login(loginRequest);
//        session.setAttribute("user_id", loggedInUser.getId());
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user", loggedInUser);
//        modelAndView.setViewName("redirect:/home");
//
//        return modelAndView;
//    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest", new RegisterRequest());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerNewUser(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        userService.register(registerRequest);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(@AuthenticationPrincipal AuthenticationDetails authenticationDetails) {

        User userById = userService.getById(authenticationDetails.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("user", userById);

        return modelAndView;
    }

//    @GetMapping("/logout")
//    public String getLogoutPage(HttpSession session) {
//
//        session.invalidate();
//
//        return "redirect:/";
//    }
}
