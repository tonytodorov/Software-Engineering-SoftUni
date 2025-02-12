package com.paintingscollectors.web;

import com.paintingscollectors.painting.service.PaintingService;
import com.paintingscollectors.user.model.User;
import com.paintingscollectors.user.service.UserService;
import com.paintingscollectors.web.dto.CreateNewPaintingRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/paintings")
public class PaintingsController {

    private final PaintingService paintingService;
    private final UserService userService;

    @Autowired
    public PaintingsController(PaintingService paintingService, UserService userService) {
        this.paintingService = paintingService;
        this.userService = userService;
    }

    @GetMapping("/new-painting")
    public ModelAndView getNewPaintingPage(HttpSession session) {

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.findUserById(userId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-painting");
        modelAndView.addObject("user", user);
        modelAndView.addObject("createNewPainting", new CreateNewPaintingRequest());

        return modelAndView;
    }

    @PostMapping("/add-painting")
    public String createNewPainting(@Valid CreateNewPaintingRequest newPaintingRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "new-painting";
        }

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.findUserById(userId);

        paintingService.createNewPainting(newPaintingRequest ,user);

        return "redirect:/home";
    }


    @PostMapping("/favourites/{id}")
    public String addPaintingToMyFavourite(@PathVariable UUID id, HttpSession session) {

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.findUserById(userId);

        paintingService.addPaintingToFavourite(id, user);

        return "redirect:/home";
    }

    @DeleteMapping("/favourites/{id}")
    public String deletePaintingFromMyFavourite(@PathVariable UUID id) {

        paintingService.deletePaintingFromFavourite(id);

        return "redirect:/home";
    }


    @DeleteMapping("/{id}")
    public String deletePainting(@PathVariable UUID id) {

        paintingService.deletePainting(id);

        return "redirect:/home";
    }

    @PutMapping("/votes/{id}")
    public String updateVotes(@PathVariable UUID id) {

        paintingService.incrementVote(id);

        return "redirect:/home";
    }
}
