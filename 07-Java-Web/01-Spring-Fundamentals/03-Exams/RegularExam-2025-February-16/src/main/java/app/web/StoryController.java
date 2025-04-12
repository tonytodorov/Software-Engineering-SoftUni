package app.web;

import app.story.model.Story;
import app.story.service.StoryService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.AddStoryRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/stories")
public class StoryController {

    private final UserService userService;
    private final StoryService storyService;

    @Autowired
    public StoryController(UserService userService, StoryService storyService) {
        this.userService = userService;
        this.storyService = storyService;
    }

    @GetMapping("/new")
    public ModelAndView getAddStoryPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-story");
        modelAndView.addObject("addStoryRequest", new AddStoryRequest());

        return modelAndView;
    }

    @PostMapping("/new")
    public String add(@Valid AddStoryRequest addStoryRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "add-story";
        }

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getUserById(userId);

        storyService.addStory(addStoryRequest, user);

        return "redirect:/home";
    }

    @DeleteMapping("/{storyId}")
    public String delete(@PathVariable UUID storyId) {

        storyService.deleteStory(storyId);

        return "redirect:/home";
    }

    @PostMapping("/{storyID}/visibility")
    public String share(@PathVariable UUID storyID) {

        Story story = storyService.getStoryById(storyID);

        storyService.shareStory(story);

        return "redirect:/home";
    }

    @GetMapping("/{storyId}")
    public ModelAndView read(@PathVariable UUID storyId) {

        Story story = storyService.getStoryById(storyId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("story");
        modelAndView.addObject("story", story);

        return modelAndView;
    }

}
