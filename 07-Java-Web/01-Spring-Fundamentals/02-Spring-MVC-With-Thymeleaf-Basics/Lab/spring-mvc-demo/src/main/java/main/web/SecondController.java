package main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
@RequestMapping("/info-2")
public class SecondController {


    @GetMapping("/time")
    public ModelAndView getInfo() {
        ModelAndView modelAndView = new ModelAndView();

        String timeNow = "Time now is " + LocalTime.now();

        modelAndView.addObject("message", timeNow);
        modelAndView.setViewName("info");

        return modelAndView;
    }
}
