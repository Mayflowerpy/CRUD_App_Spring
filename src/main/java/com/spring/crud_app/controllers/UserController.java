package com.spring.crud_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome!");
        messages.add("Please, click the button to go to the users table");
        model.addAttribute("messages", messages);
        return "index";
    }

//    @GetMapping(value = "/users")
//    public String userTable() {
//
//        return "users";
//    }

}
