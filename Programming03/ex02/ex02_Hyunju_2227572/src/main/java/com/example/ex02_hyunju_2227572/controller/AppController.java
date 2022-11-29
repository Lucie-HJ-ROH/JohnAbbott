package com.example.ex02_hyunju_2227572.controller;

import com.example.ex02_hyunju_2227572.dto.UserRepository;
import com.example.ex02_hyunju_2227572.model.User;
import com.example.ex02_hyunju_2227572.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repo;

    @RequestMapping("/")
    public String viewHomePage(Model model) {

        System.out.println("Index");
        return "Index";
    }


    @GetMapping("/register")
    public String showRegistrationsFrom(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        List<String> listBloodGroup = Arrays.asList("A+", "B+", "O+", "AB+","A-", "B-", "O-", "AB-");
        model.addAttribute("listBloodGroup", listBloodGroup);

        return "Index";
    }

//
//    @PostMapping("/process_register")
//    public String processRegister(@Valid @ModelAttribute("user")User user) {
//
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        userRepo.save(user);
//
//        return "register_success";
//    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("user") User user) {
        service.save(user);

        return "redirect:/";
    }


}
