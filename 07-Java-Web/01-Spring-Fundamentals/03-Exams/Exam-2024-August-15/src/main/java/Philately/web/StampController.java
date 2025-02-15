package Philately.web;


import Philately.stamp.service.StampService;
import Philately.user.model.User;
import Philately.user.service.UserService;
import Philately.web.dto.CreateNewStampRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class StampController {

    private final StampService stampService;
    private final UserService userService;

    public StampController(StampService stampService, UserService userService) {
        this.stampService = stampService;
        this.userService = userService;
    }

    @GetMapping("/stamp/new")
    public ModelAndView getAddStampPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-stamp");
        modelAndView.addObject("createNewStampRequest", new CreateNewStampRequest());

        return modelAndView;
    }

    @PostMapping("/stamp/create")
    public String createNewStamp(@Valid CreateNewStampRequest createNewStampRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "add-stamp";
        }

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getUserById(userId);

        stampService.createNewStamp(createNewStampRequest, user);

        return "redirect:/home";
    }


    @PostMapping("/stamp/add-wishlist/{id}")
    public String addStampToWishlist(@PathVariable UUID id, HttpSession session) {

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getUserById(userId);

        stampService.addStampToWishlist(id, user);

        return "redirect:/home";
    }

    @DeleteMapping("/stamp/remove/{id}")
    public String removeStampFromWishlist(@PathVariable UUID id) {

        stampService.removeStampFromWishlist(id);

        return "redirect:/home";
    }
}
