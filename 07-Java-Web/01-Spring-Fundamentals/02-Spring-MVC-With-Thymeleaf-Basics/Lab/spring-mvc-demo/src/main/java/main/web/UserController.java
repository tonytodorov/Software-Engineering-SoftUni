package main.web;

import main.model.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ModelAndView getUserDetails(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();

        User userById = userService.getUserById(id);

        modelAndView.addObject("user", userById);
        modelAndView.setViewName("user-details");

        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users = userService.getAllUsers();

        modelAndView.addObject("users", users);
        modelAndView.setViewName("users");

        return modelAndView;
    }
}
