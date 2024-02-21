package ru.ld.Manager.controllers;

import org.springframework.web.bind.annotation.*;
import ru.ld.Manager.model.User;
import ru.ld.Manager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/managers")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/managers";
    }

    @GetMapping("user-delete/{id}")
    String deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/managers";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/managers";
    }
}
