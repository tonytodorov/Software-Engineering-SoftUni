package app.web;

import app.notification.client.dto.Notification;
import app.notification.client.dto.NotificationPreference;
import app.notification.service.NotificationService;
import app.security.AuthenticationDetails;
import app.user.model.User;
import app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    private final UserService userService;
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @GetMapping
    public ModelAndView getNotificationPage(@AuthenticationPrincipal AuthenticationDetails authenticationDetails) {

        User user = userService.getById(authenticationDetails.getId());

        NotificationPreference notificationPreference = notificationService.getNotificationPreference(user.getId());
        List<Notification> notificationHistory = notificationService.getNotificationHistory(user.getId());
        notificationHistory = notificationHistory.stream().limit(5).toList();

        long succeededNotifications = notificationHistory
                .stream()
                .filter(notification -> notification.getStatus().equals("SUCCEEDED"))
                .count();

        long failedNotifications = notificationHistory
                .stream()
                .filter(notification -> notification.getStatus().equals("FAILED"))
                .count();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notifications");
        modelAndView.addObject("user", user);
        modelAndView.addObject("notificationPreference", notificationPreference);
        modelAndView.addObject("succeededNotifications", succeededNotifications);
        modelAndView.addObject("failedNotifications", failedNotifications);
        modelAndView.addObject("notificationHistory", notificationHistory);

        return modelAndView;
    }

    @GetMapping("/user-preference")
    public String updateUserPreference(@RequestParam(name = "enabled") boolean enabled, @AuthenticationPrincipal AuthenticationDetails authenticationDetails) {

        notificationService.updateNotificationPreference(authenticationDetails.getId(), enabled);

        return "redirect:/notifications";
    }
}
