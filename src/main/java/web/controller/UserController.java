package web.controller;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userServiceImp) {
        this.userService = userServiceImp;
    }


    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("something", "All User table");
        model.addAttribute("user", userService.getAllUsers());
        return "user";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("something", "One User table");
        model.addAttribute("user", userService.showUserById(id));
        return "one user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}

