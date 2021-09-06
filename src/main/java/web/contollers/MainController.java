package web.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.servise.UserService;

import java.security.Principal;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String index (Principal principal, Model model) {
        model.addAttribute("userName", principal.getName());
        return "index";
    }

    @GetMapping("/login")
    public String formlogin() {
        return "login";
    }

    @GetMapping("/user")
    public String userProfile(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "users/user";
    }
}
