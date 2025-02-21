package app.web;

import app.security.AuthenticationDetails;
import app.user.model.User;
import app.user.service.UserService;
import app.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WalletController {

    private final UserService userService;
    private final WalletService walletService;

    @Autowired
    public WalletController(UserService userService, WalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    @GetMapping("/wallets")
    public ModelAndView getWallets(@AuthenticationPrincipal AuthenticationDetails authenticationDetails) {

        User user = userService.getById(authenticationDetails.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wallets");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PostMapping
    public String createNewWallet(@AuthenticationPrincipal AuthenticationDetails authenticationDetails) {

        User user = userService.getById(authenticationDetails.getId());

        walletService.unlockNewWallet(user);

        return "redirect:/wallets";
    }

}
