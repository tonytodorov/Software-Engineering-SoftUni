package main.web;

import main.model.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/controller")
public class TestController {

    private final UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ModelAndView getCount(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();

        User userById = userService.getUserById(id);

        modelAndView.addObject("nothing", userById);

        modelAndView.setViewName("info");

        return modelAndView;
    }

}
