package web.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String userList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @GetMapping("{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/user";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("roles", userService.getRoles());
        model.addAttribute("user", new User());
        return "admin/new";
    }

    @PostMapping("new")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        // Если есть ошибки, просим исправить
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", userService.getRoles());
            return "admin/new";
        }

        // Если юзер с таким именем уже существует, сообщим об этом
        if (userService.getUserByName(user.getName()) != null) {
            bindingResult.addError(new FieldError("name", "name",
                    String.format("User with name \"%s\" is already exist!", user.getName())));
            model.addAttribute("roles", userService.getRoles());
            return "admin/new";
        }

        // Иначе достаем из базы указанные роли, кладем в юзера и сохраняем
        user.setRoles(user.getRoles().stream()
                .map(role -> userService.getByName(role.getName()))
                .collect(Collectors.toSet()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", userService.getRoles());
        return "admin/edit";
    }

    @PatchMapping("{id}/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        // Если есть ошибки, поросим исправить
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", userService.getRoles());
            return "admin/edit";
        }

        // Иначе достаем из базы указанные роли, кладем в юзера и сохраняем
        user.setRoles(user.getRoles().stream()
                .map(role -> userService.getByName(role.getName()))
                .collect(Collectors.toSet()));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}
