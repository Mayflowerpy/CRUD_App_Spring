package com.spring.crud_app.controllers;

import com.spring.crud_app.models.User;
import com.spring.crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome!");
        messages.add("Please, click the link to go to the users table");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/users")
    public String userTable(Model model) {
        model.addAttribute("usersList", userService.getUsersList());
        return "users";
    }

    @GetMapping("/users/{userId}")
    public String getContactById(Model model, @PathVariable("userId") long userId) {
            model.addAttribute("user", userService.getById(userId));
        return "user";
    }

    @GetMapping("/newUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
//        userService.deleteUser();
        return "redirect:/users";
    }

    @GetMapping("/updateUser")
    public String updateUser() {
//        userService.updateUser();
        return "redirect:/users";
    }

}
