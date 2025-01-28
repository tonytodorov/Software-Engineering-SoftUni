package app.web;

import app.user.model.User;
import app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//
//    @GetMapping("/users/profile")
//    public ModelAndView editProfile() {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("profile-menu");
//
//        User userById = userService.getById(UUID.fromString("0dbf6c0a-b381-4069-94cc-2597df0378b8"));
//
//        modelAndView.addObject("user", userById);
//
//        return modelAndView;
//    }
//
//    @GetMapping("/users")
//    public ModelAndView getUsers() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<User> allUsers = userService.getAllUsers();
//
//        modelAndView.setViewName("users");
//        modelAndView.addObject("users", allUsers);
//
//        return modelAndView;
//    }

    @GetMapping("/{id}/profile")
    public ModelAndView getProfileMenu(@PathVariable UUID id) {

        User user = userService.getById(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("profile-menu");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
