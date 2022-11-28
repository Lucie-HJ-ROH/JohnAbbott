package com.example.ex.controller;

import com.example.ex.dao.UserDataRepo;
import com.example.ex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class DataController {

    @Autowired
    UserDataRepo repo;

    @RequestMapping("/register")
    public String home() {
        System.out.println("Going home ...");
        return "index";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        System.out.println("Loading form");
        System.out.println(user);

        if (bindingResult.hasErrors()) {
            return "register_form";
        }

        if(!user.getPassword().equals(user.getRepassword())){
            bindingResult.rejectValue("rePassword", "mismatched password", "Please enter a same password");
            return "register_form";
        }
        repo.save(user);
        return "register_success";
    }
}
