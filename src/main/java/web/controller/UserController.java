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

    @GetMapping()
    public String getUserList(Model model,
                              @RequestParam(value = "count", required = false) Integer count) {
        model.addAttribute("something", "User table");
        model.addAttribute("user", userService.getCountUsers(count));
        return "user";
    }

    @GetMapping("/all")
    public String getUserList(Model model) {
        model.addAttribute("something", "All User table");
        model.addAttribute("user", userService.getUsers());
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("something", "One User table");
        model.addAttribute("user", userService.show(id));
        return "one user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        userService.upDate(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}

