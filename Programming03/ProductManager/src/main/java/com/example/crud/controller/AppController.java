package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class AppController {


    @Autowired
    private UserService service;



    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "home";
    }

    @RequestMapping("/new")
    public String showNewUserPage(Model model) {
        User user = new User();

        return "signup";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        service.save(user);

        return "signin";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id, Model model) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = service.get(id);
        mav.addObject("user", user);
        return mav;
    }


    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }


    @RequestMapping("/welcome")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "welcome";
    }

}
