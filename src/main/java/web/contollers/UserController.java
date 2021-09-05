package web.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.servise.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/users";
    }

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/user";
    }

    @GetMapping("/admin/new")
    public String newUser(Model model) {
        model.addAttribute("roles", userService.getRoles());
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/admin/new")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "roleIdList") List<Long> roleIdList) {
        roleIdList.forEach(id -> user.addRole(userService.getRoleById(id)));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", userService.getRoles());
        return "users/edit";
    }

    @PatchMapping("/admin/{id}/edit")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "roleIdList") List<Long> roleIdList) {
        roleIdList.forEach(id -> user.addRole(userService.getRoleById(id)));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}
