package com.spring.crud_app.controllers;

import com.spring.crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printWelcome(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome!");
        messages.add("Please, click the link to go to the users table");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/users")
    public String userTable(Model model) {
            model.addAttribute("usersList", userService.getUsersList());
        return "users";
    }

}
