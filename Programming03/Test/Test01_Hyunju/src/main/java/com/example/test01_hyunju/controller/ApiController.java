package com.example.test01_hyunju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {


    @RequestMapping("/")
    public String home() {
        System.out.println("Going home ...");
        return "index";
    }
}
