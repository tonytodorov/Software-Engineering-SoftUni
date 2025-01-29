package app.web;

import app.user.model.User;
import app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class WalletController {

    private final UserService userService;

    @Autowired
    public WalletController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/wallets")
    public String getWallets() {

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("wallets");
//
//        User userById = userService.getById(UUID.fromString("076d3e82-7f99-4cb2-9c69-8b0679c78978"));
//
//        modelAndView.addObject("user", userById);

        return "wallets";
    }

}
